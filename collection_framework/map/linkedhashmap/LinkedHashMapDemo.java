package collection_framework.map.linkedhashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class LinkedHashMapStringDemo {
    
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(10, .75f, true); // last argument is to toggle accessOrder
        // LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(10, .75f); // don't remember last accessOrder

        System.out.println(linkedHashMap.size());

        linkedHashMap.put("1003", "aaaa");
        linkedHashMap.put("1002", "bbbb");
        linkedHashMap.put("1001", "cccc");
        linkedHashMap.put("1004", "dddd");

        System.out.println("Printing without accessing via get()");
        Set entrySet = linkedHashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            System.out.println(k + " = " + v);
        }

        System.out.println("Printing via get()");
        Stream.of("1001", "1002", "1003", "1004").forEach(str -> System.out.println(str + " = " + linkedHashMap.get(str)));

        System.out.println("Printing without accessing via get()");
        entrySet = linkedHashMap.entrySet();
        iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            System.out.println(k + " = " + v);
        }
    }
}


class LinkedHashMapCustomClassDemo {
    
    public static void main(String[] args) {
        LinkedHashMap<Emp1, String> customClassLinkedHashMap = new LinkedHashMap<>();

        System.out.println(customClassLinkedHashMap.size());

        customClassLinkedHashMap.put(new Emp1(10), "aaaa");
        customClassLinkedHashMap.put(new Emp1(20), "bbbb");
        customClassLinkedHashMap.put(new Emp1(30), "cccc");
        customClassLinkedHashMap.put(new Emp1(40), "dddd");

        System.out.println("Printing without accessing via get()");
        Set entrySet = customClassLinkedHashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Emp1 k = (Emp1)entry.getKey();
            String v = (String)entry.getValue();
            System.out.println(k + " = " + v);
        }

        System.out.println("Is Map Empty? " + customClassLinkedHashMap.isEmpty());

        Emp1 e1 = new Emp1(40);
        System.out.println(customClassLinkedHashMap.get(e1));
        System.out.println("contains key? " + customClassLinkedHashMap.containsKey(e1));
        System.out.println("contains value? " + customClassLinkedHashMap.containsValue("bbbb"));

        customClassLinkedHashMap.remove(e1);

        System.out.println("Printing after remove()");
        entrySet = customClassLinkedHashMap.entrySet();
        iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Emp1 k = (Emp1)entry.getKey();
            String v = (String)entry.getValue();
            System.out.println(k + " = " + v);
        }
    }
}

class Emp1 {
    int id;

    Emp1(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Emp1 e = (Emp1)o;
        return e.id == this.id;
    }

    @Override
    public int hashCode() {
        return id * 10;
    }

    @Override
    public String toString() {
        return "Emp1 id value is: " + Integer.toString(this.id);
    }
}
