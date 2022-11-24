package collection_framework.map.hashmap;

/*
 * Not by default: Shallow Cloning
 */
import java.util.HashMap;

public class HashMap_cloning {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        System.out.println(hashMap.size());

        hashMap.put("1000", "aaaa");
        hashMap.put("1001", "bbbb");
        hashMap.put("1002", "cccc");
        hashMap.put("1003", "dddd");

        hashMap.put(new String("10001"), "zzzz");

        System.out.println("Original HashMap: " + hashMap);

        HashMap clonedHashMap = (HashMap)hashMap.clone();

        System.out.println("Cloned HashMap: " + clonedHashMap);

    }
}
