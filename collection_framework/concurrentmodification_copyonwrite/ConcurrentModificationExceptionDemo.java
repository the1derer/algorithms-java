package collection_framework.concurrentmodification_copyonwrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.addAll(Arrays.asList("b", "c"));

        try {
            ArrayListThread1 alt1 = new ArrayListThread1(arrayList);
            Thread tt1 = new Thread(alt1);

            ArrayListThread2 alt2 = new ArrayListThread2(arrayList);
            Thread tt2 = new Thread(alt2);
            
            tt1.setPriority(10);
            tt2.setPriority(1);

            tt1.start();
            tt2.start();

        } catch(Exception exception) {
            System.out.println("Exception: " + exception);
        }

        System.out.println(arrayList);
    }
    
}

class ArrayListThread1 implements Runnable {

    ArrayList<String> cowal;

    ArrayListThread1(ArrayList<String> cowal) {
        this.cowal = cowal;
    }

    public void run() {
        Iterator<String> iterator = cowal.iterator();

        while(iterator.hasNext()) {
            try {
                String str = iterator.next();
                System.out.println("Name: " + str);
                Thread.sleep(10000);
            } catch(Exception exception) {
                System.out.println("Exception in reading: " + exception);
            }
        }
    }
}

class ArrayListThread2 implements Runnable {

    ArrayList<String> cowal;

    ArrayListThread2(ArrayList<String> cowal) {
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