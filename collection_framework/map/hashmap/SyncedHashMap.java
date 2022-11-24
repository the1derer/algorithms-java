package collection_framework.map.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SyncedHashMap {
    public static void main(String[] args) {
        Map syncedMap = Collections.synchronizedMap(new HashMap<Integer, String>());

        syncedMap.put(2, "Anil");
        syncedMap.put(44, "Ajit");
        syncedMap.put(4, "Sachit");
        syncedMap.put(88, "xyz");

        Set entrySet = syncedMap.entrySet();

        // TODO: Learn what does 'synchronized' block mean
        synchronized(syncedMap) {
            Iterator iterator = entrySet.iterator();

            while(iterator.hasNext()) {
                Map.Entry me = (Map.Entry) iterator.next();
                System.out.println("key: " + me.getKey() + " value: " + me.getValue());
            }
        }

        
    }
}
