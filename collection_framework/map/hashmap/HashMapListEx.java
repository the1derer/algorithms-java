package collection_framework.map.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HashMapListEx
 */
public class HashMapListEx {

    public static void main(String[] args) {
        Map<Integer, List<String>> mapOfIntStrs = new HashMap<>();
        
        add(mapOfIntStrs, 1, "one");
        add(mapOfIntStrs, 2, "two");
        add(mapOfIntStrs, 3, "three");
        add(mapOfIntStrs, 4, "four");
        add(mapOfIntStrs, 5, "five");

        Set<Integer> keySet = mapOfIntStrs.keySet();

        keySet.forEach(i -> mapOfIntStrs.get(i).forEach(System.out::println));
        
    }

    public static final void add(Map<Integer, List<String>> mapToAdd, int keyNum, String value) {
        if(mapToAdd.containsKey(keyNum)) {
            mapToAdd.get(keyNum).add(value);
        } else {
            List<String> strList = new ArrayList<>(Arrays.asList(value));
            mapToAdd.put(keyNum, strList);
        }
    }
}