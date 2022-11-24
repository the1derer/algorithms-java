package collection_framework.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HashMap_demo
 */
class HashMapStringDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        System.out.println(hashMap.size());

        hashMap.put("1000", "aaaa");
        hashMap.put("1001", "bbbb");
        hashMap.put("1002", "cccc");
        hashMap.put("1003", "dddd");

        hashMap.put(new String("10001"), "zzzz");

        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();

        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        while(iterator.hasNext()) {
            Map.Entry<String, String> e = iterator.next();
            String keyString = e.getKey();
            String valString = e.getValue();

            System.out.println("key: " + keyString + ", value: " + valString);
        }
    }
}

class HashMapCustomKeyDemo { // adding objects of our own class as key
    public static void main(String[] args) {
        HashMap<Emp1, String> customkeyHashMap = new HashMap<>();

        System.out.println(customkeyHashMap.size());

        customkeyHashMap.put(new Emp1(10), "aaaa");
        customkeyHashMap.put(new Emp1(20), "bbbb");
        customkeyHashMap.put(new Emp1(30), "cccc");
        customkeyHashMap.put(new Emp1(40), "dddd");
        customkeyHashMap.put(new Emp1(20), "eeee"); // same key diff value, if we uncomment this equals method will not run as there is no non-unique key. If we don't override equals method instead of overriding HashMap will create a new entry

        Set set = customkeyHashMap.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Emp1 key = (Emp1)entry.getKey();
            String valString = (String)entry.getValue();
            System.out.println("key: " + key + ", value: " + valString);
        }

        Emp1 emp = new Emp1(40);
        String ss = customkeyHashMap.get(emp);
        System.out.println(ss);

        customkeyHashMap.remove(emp);

        set = customkeyHashMap.entrySet();
        iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Emp1 key = (Emp1)entry.getKey();
            String valString = (String)entry.getValue();
            System.out.println("key: " + key + ", value: " + valString);
        }

        customkeyHashMap.clear();
        System.out.println("Is HashMap empty? " + customkeyHashMap.isEmpty());


    }
}

class Emp1 {
    int id;

    Emp1(int id) {
        this.id = id;
        // System.out.println(hashCode());
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Emp1 equals() method");
        return this.id == ((Emp1)o).id;
    }

    @Override
    public int hashCode() {
        System.out.println("Emp1 hashCode() method");
        return id*10;
    }
    /*
     * NOTE:
     * Comment out 'equals()' method to have new object for every key-value pair. Only for checking and understanding the use of overriding equals() method
     */
}