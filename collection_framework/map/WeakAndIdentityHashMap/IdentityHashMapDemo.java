package collection_framework.map.WeakAndIdentityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * IdentityHashMapDemo
 */
public class IdentityHashMapDemo {

    public static void main(String[] args) {
        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();

        HashMap<String, String> hashMap = new HashMap<>();

        identityHashMap.put("sony", "bravia");
        identityHashMap.put(new String("sony"), "mobile"); // will override above value as "sony" != new String("sony"), coz string litral and String Object have different reference and identityHashMap uses '=='(which just compares the Ref. ID) instead of equals().

        hashMap.put("sony", "bravia");
        hashMap.put(new String("sony"), "mobile"); // will override the value in above "sony" key as hashMap uses equals() method

        
        /* size of identityHashMap should be 2 here becoz 2 strings are different object */
        System.out.println("size of identityHashMap: " + identityHashMap.size());
        System.out.println("size of hashMap: " + hashMap.size());

        System.out.println("IdentityHashMap: " + identityHashMap);
        System.out.println("HashMap: " + hashMap);

        identityHashMap.put("sony", "videogame");

        // size of identityMap will still be same
        System.out.println("size of identityHashMap: " + identityHashMap.size());
        System.out.println("IdentityHashMap: " + identityHashMap);

        
        
    }
}