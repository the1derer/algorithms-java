package collection_framework.map.treemap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TreeMapDemo: This demo implements Comparable, for Comparator see other Demo
 */
public class TreeMapComparableDemo {

    public static void main(String[] args) {
        TreeMap<Temp, String> treeMap = new TreeMap<>();

        System.out.println("Initial size: " + treeMap.size());

        treeMap.put(new Temp(10), "dddd");
        treeMap.put(new Temp(5), "ccc");
        treeMap.put(new Temp(4), "bbbb");
        treeMap.put(new Temp(3), "aaaa");
        
        show(treeMap);

        Temp e1 = new Temp(10);

        //------------------------headMap()---------------------------
        // SortedMap headSortedMap = treeMap.headMap(e1);
        SortedMap headSortedMap = treeMap.headMap(e1, true); // second argument is to toggle upper limit inclusive or not
        System.out.println("less than 10");
        show(headSortedMap);

        
        e1 = new Temp(1);

        //------------------------tailMap()---------------------------
        SortedMap tailSortedMap = treeMap.tailMap(e1);
        System.out.println("greater than 1");
        show(tailSortedMap);

        Temp e2 = new Temp(10);

        //------------------------subMap()-----------------------------
        // SortedMap subMap = treeMap.subMap(e1, e2);
        SortedMap subMap = treeMap.subMap(e1, true, e2, true);
        System.out.println("b/w 1 and 10");
        show(subMap);

        //--------------------
        System.out.println("isEmpty(): " + treeMap.isEmpty());
        
        System.out.println("get(): " + treeMap.get(e2));

        System.out.println("remove:");
        treeMap.remove(e2);
        show(treeMap);
        System.out.println("size after removal: " + treeMap.size());
    }

    static void show(Map<Temp, String> map) {
        
        map.entrySet().stream().forEach(entry -> {
           System.out.println(entry.getKey().x + " = " + entry.getValue()); 
        });
        
    }
}

class Temp implements Comparable<Temp> {
    int x;

    Temp(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(Temp t) {
        if(this.x == t.x)
            return 0;
        else
            return this.x > t.x ? 1 : -1;
    }
}