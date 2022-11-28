package collection_framework.collections_and_arrays_class;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Collections class provides many methods to perform tasks on Collection and its child classes.
 * Methods like BinarySearch, frequencyCount, max, min etc.
 */

public class CollectionsClassDemo {
    public static void main(String[] args) {

        List<String> exampleList = IntStream.rangeClosed(1, 10).shuffle().collect(Collectors.toList());
        System.out.println("Initial ArrayList: " + exampleList);

        System.out.println("----------------- Collections.sort() ------------------");
        System.out.println(Collections.sort(exampleList));


        System.out.println("----------------- Collections.binarySearch() ------------------");
        System.out.println("Element found at index: " + Collections.binarySearch(exampleList, "2"));

        
        System.out.println("----------------- Collections.enumeration() ------------------");
        Enumeration<String> enumeration = Collections.enumeration(exampleList);
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }


        System.out.println("----------------- Collections.addAll() ------------------");
        List<String> addAllExampleList = new ArrayList<>(Arrays.asList("java", "c", "c++"));
        System.out.println("Initial addAllExampleList: " + addAllExampleList);

        // add variable length elements
        Collections.addAll(addAllExampleList, "perl", "php");
        Collections.addAll(addAllExampleList, "python", "javascript", "scala");

        // add array
        String[] strArr = {".net", "unix"};
        Collections.addAll(addAllExampleList, strArr);

        // add another 'Collection'
        Collections.addAll(addAllExampleList, exampleList);


        System.out.println("After allAll() operations: " + addAllExampleList);


        System.out.println("----------------- Collections.copy() ------------------");


        System.out.println("----------------- Collections.max() and Collections.min() ------------------");
        List<Integer> maxMinExample = new ArrayList<>(IntStream.range(1, 9).shuffle().boxed().toList());
        System.out.println("maxMixExampleList: " + maxMinExample);

        Integer maxObj = Collections.max(maxMinExample);
        System.out.println("max element: " + maxObj);

        Object minObj = Collections.min(maxMinExample);
        System.out.println("min element: " + maxObj);


        System.out.println("---------- Collections.max() and Collections.min() CustomClass ------------");
        List<CustomClass> customClassList = new ArrayList<>(IntStream.rangeClosed(1, 5).forEach(new CustomClass(i).toList()));

    }
}

class CustomClass implements Comparable<CustomClass> {
    int id;
    CustomClass(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(CustomClass object) {
        return this.id == object.id ? 0 : (this.id > object.id ? 1 : -1);
    }

}