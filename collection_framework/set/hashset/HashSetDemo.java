package collection_framework.set.hashset;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        System.out.println("Initial size: " + hashSet.size());

        System.out.println("----------------add()--------------");
        Stream.of("a", "b", "c", "d").forEach(str -> hashSet.add(str));
        System.out.println("Size after adding: " + hashSet.size());
        System.out.println(hashSet);

        
        System.out.println("----------------addAll()--------------");
        Collection<String> subSet = new HashSet<>();
        subSet.add("s1");
        subSet.add("s2");

        hashSet.addAll(subSet);
        System.out.println("hashSet content after adding another collection: " + hashSet);


        System.out.println("----------------retainAll()--------------");
        HashSet<String> retainAllHashSetEx = new HashSet<>();
        Stream.of("first", "second", "third", "forth", "apple", "rat").forEach(str -> retainAllHashSetEx.add(str));
        System.out.println("retainAllHashSetEx content before retainAll(): " + retainAllHashSetEx);

        Collection<String> retainAllSubSetEx = new HashSet<>();
        Stream.of("rat", "second", "first", "shubham").forEach(str -> retainAllSubSetEx.add(str));

        retainAllHashSetEx.retainAll(retainAllSubSetEx); // retains only those elements that are in subset

        System.out.println("retainAllHashSetEx content after retainAll(): " + retainAllHashSetEx);


        System.out.println("----------------HashSet to Array--------------");

        HashSet<String> hashSetToArrayEx = new HashSet<>();
        Stream.of("rat", "second", "first", "shubham").forEach(str -> hashSetToArrayEx.add(str));
        System.out.println("HashSet content: " + hashSetToArrayEx);

        String[] stringArray = new String[hashSetToArrayEx.size()];
        hashSetToArrayEx.toArray(stringArray);

        System.out.println("Copied Array content: " );
        Arrays.stream(stringArray).forEach(System.out::println);      
        
        
    }
}
