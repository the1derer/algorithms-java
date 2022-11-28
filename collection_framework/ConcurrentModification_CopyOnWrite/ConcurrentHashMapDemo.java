package collection_framework.ConcurrentModificationAndCopyOnWrite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/*
 * Used to avoid ConcurrentModification Exception
 */

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        IntStream.rangeClosed(1, 7).filter(i -> i !=2).forEach(i -> concurrentMap.put(String.valueOf(i), "1"));
        System.out.println("ConcurrentHashMap before Iterator: " + concurrentMap);
        Iterator<String> iterator = concurrentMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if(key.equals("3")) { // goes inside if block
                System.out.println("Print statement from if inside HashMap while loop");
                concurrentMap.put(key + " new", "new3");
            }
        }
        System.out.println("Concurrent HashMap after iterator: " + concurrentMap);


        // HashMap------------------------------------------------------------------------------------
        Map<String, String> hashMap = new HashMap<String, String>();
        IntStream.rangeClosed(1, 7).forEach(i -> hashMap.put(String.valueOf(i), "1"));
        System.out.println("HashMap before iterator: " + hashMap);
        Iterator<String> iterator2 = hashMap.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator2.next();
            if(key.equals("3")) { // will not go inside if block
                System.out.println("Print statement from if inside HashMap while loop");
                hashMap.put(key + " new", "new3");
            }
        }
        System.out.println("HashMap after iterator: " + hashMap);
    }
    
}