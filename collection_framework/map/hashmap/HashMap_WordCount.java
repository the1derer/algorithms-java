package collection_framework.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMap_WordCount {
    public static void main(String[] args) {
        String inputString = "this is a test this is a test Shubham Raj";

        String[] splitted = inputString.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for(String str : splitted) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        System.out.println(map);
    }
}
