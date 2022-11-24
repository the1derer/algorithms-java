package ConcurrentModificationAndCopyOnWrite;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList_Demo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyWriteArrayList = new CopyOnWriteArrayList<>();
        copyWriteArrayList.add("a");
        copyWriteArrayList.addAll(Arrays.asList("b", "c"));

        try {
            ArrayListThread1 alt1 = new ArrayListThread1(copyWriteArrayList);
            Thread tt1 = new Thread(alt1);

            ArrayListThread2 alt2 = new ArrayListThread2(copyWriteArrayList);
            Thread tt2 = new Thread(alt2);
            
            tt1.setPriority(10);

            tt1.start();
            tt2.start();

            tt1.join();
            tt2.join();
        } catch(Exception exception) {
            System.out.println("Exception: " + exception);
        }

        System.out.println(copyWriteArrayList);
    }
    
}

class ArrayListThread1 implements Runnable {

    CopyOnWriteArrayList<String> cowal;

    ArrayListThread1(CopyOnWriteArrayList<String> cowal) {
        this.cowal = cowal;
    }

    public void run() {
        Iterator<String> iterator = cowal.iterator();

        while(iterator.hasNext()) {
            try {
                String str = iterator.next();
                System.out.println("Name: " + str);
                Thread.sleep(1000);
            } catch(Exception exception) {
                System.out.println("Exception in reading: " + exception);
            }
        }
    }
}

class ArrayListThread2 implements Runnable {

    CopyOnWriteArrayList<String> cowal;

    ArrayListThread2(CopyOnWriteArrayList<String> cowal) {
        this.cowal = cowal;
    }

    public void run() {
        try {
            for(int i = 0; i < 5; i++) {
                cowal.add("first");
                cowal.add("second");
                Thread.sleep(2000);
            }
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}