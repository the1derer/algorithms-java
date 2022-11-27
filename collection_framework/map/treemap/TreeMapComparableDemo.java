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

        Temp e1 = new Temp(1);
        Temp e4 = new Temp(4);
        Temp e10 = new Temp(10);

        System.out.println("------------------------headMap()---------------------------");
        // SortedMap headSortedMap = treeMap.headMap(e1);
        SortedMap<Temp, String> headSortedMap4 = treeMap.headMap(e4, true); // second argument is to toggle upper limit inclusive or not
        System.out.println("less than 4(inclusive)");
        show(headSortedMap4);

        
        System.out.println("------------------------tailMap()---------------------------");
        SortedMap<Temp, String> tailSortedMap4 = treeMap.tailMap(e4); // lower bound, default inclusive
        System.out.println("greater than 4");
        show(tailSortedMap4);

        SortedMap<Temp, String> tailSortedMap1 = treeMap.tailMap(e1); // lower bound
        System.out.println("greater than 1");
        show(tailSortedMap1);

        System.out.println("------------------------subMap()---------------------------");
        // SortedMap subMap = treeMap.subMap(e1, e2); // ranges not inclusive
        SortedMap<Temp, String> subMap410 = treeMap.subMap(e4, true, e10, true);
        System.out.println("b/w 4 and 10 inclusive");
        show(subMap410);

        SortedMap<Temp, String> subMap14 = treeMap.subMap(e1, e4);
        System.out.println("b/w 1 and 4 exclusive");
        show(subMap14);

        System.out.println("------------------------isEmpty() & get()---------------------------");
        System.out.println("isEmpty(): " + treeMap.isEmpty());
        
        System.out.println("get(): " + treeMap.get(e4));
        System.out.println("get(): " + treeMap.get(e1));

        System.out.println("------------------------remove()---------------------------");
        treeMap.remove(e1);
        System.out.println("after removing 1 :");
        show(treeMap);
        System.out.println("size after removal: " + treeMap.size());


        System.out.println("---------------descendingMap()-----------------");
        Map<Temp, String> descendingMap = treeMap.descendingMap();
        show(descendingMap);
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