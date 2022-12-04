package collection_framework.concurrentmodification_copyonwrite;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.IntStream;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        // TODO: Find out why this is giving error
        // IntStream.range(1, 7).forEach(i -> copyOnWriteArraySet.add(String.valueOf(i)));

        copyOnWriteArraySet.add("1");
        copyOnWriteArraySet.add("2");
        copyOnWriteArraySet.add("3");
        copyOnWriteArraySet.add("4");
        copyOnWriteArraySet.add("5");
        copyOnWriteArraySet.add("6");

        System.out.println("CopyOnWriteArraySet before iterator: " + copyOnWriteArraySet);

        Iterator<String> iterator = copyOnWriteArraySet.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            if(key.equals("3")) {
                copyOnWriteArraySet.add(key + " new");
            }
        }
        System.out.println("CopyOnWriteArraySet after iterator: " + copyOnWriteArraySet);

        //---------------------------------------------------------------------------------------
        copyOnWriteArraySet = new HashSet<>(); // new HashSet<String>() => will give Concurrent modification Exception;

        System.out.println("CopyOnWriteArraySet before iterator: " + copyOnWriteArraySet);

        // IntStream.range(1, 7).forEach(i -> copyOnWriteArraySet.add(String.valueOf(i)));

        copyOnWriteArraySet.add("1");
        copyOnWriteArraySet.add("2");
        copyOnWriteArraySet.add("3");
        copyOnWriteArraySet.add("4");
        copyOnWriteArraySet.add("5");
        copyOnWriteArraySet.add("6");

        Iterator<String> iterator1 = copyOnWriteArraySet.iterator();

        while(iterator1.hasNext()) {
            String key = iterator1.next();
            if(key.equals("3")) {
                copyOnWriteArraySet.add(key + " new");
            }
        }

        System.out.println("HashSet after iterator: " + copyOnWriteArraySet);        

    }
}
