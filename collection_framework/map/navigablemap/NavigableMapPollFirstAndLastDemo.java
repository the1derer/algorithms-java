package collection_framework.map.navigablemap;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class NavigableMapPollFirstAndLastDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        navigableMap.put(2, "two");
        navigableMap.put(1, "one");
        navigableMap.put(3, "three");
        navigableMap.put(22, "twenty-two");
        navigableMap.put(91, "nintly-one");
        navigableMap.put(951, "three");

        System.out.println("Original Map: " + navigableMap);

        System.out.println("--------------pollFirst()---------------");
        Entry<Integer, String> firstEntry = navigableMap.pollFirstEntry();
        System.out.println("First(smallest) entry: " + firstEntry);
        System.out.println("After polling the first entry: " + navigableMap);


        System.out.println("--------------pollLast()---------------");
        Entry<Integer, String> lastEntry = navigableMap.pollLastEntry();
        System.out.println("Last(largest) entry: " + lastEntry);
        System.out.println("After polling the last entry: " + navigableMap);

    }
}
