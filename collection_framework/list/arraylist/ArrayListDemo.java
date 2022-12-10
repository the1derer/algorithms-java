package collection_framework.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListDemo {

    public static void main(String[] args) {

        System.out.println("----------------Adding and removing element-----------------");

        ArrayList<String> list1 = new ArrayList<>();

        // ArrayList list = new ArrayList(); // non-generic version

        list1.add("d");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("b");

        // list.add(Integer.valueOf(10)); // works in case of non-generics ArrayList, also note here
        // we are able to add 'Integer' to an String ArrayList, which shouldn't have happened

        System.out.println(list1.size());
        System.out.println(list1);

        list1.remove(2); // removing 'c'

        System.out.println(list1.size());
        System.out.println(list1);


        System.out.println("-------------------------------get() / set()-------------------");

        ArrayList<Integer> getSetDemo = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("ArrayList before Update: " + getSetDemo);

        getSetDemo.set(0, 11);
        getSetDemo.set(1, 22);
        getSetDemo.set(2, 33);
        getSetDemo.set(3, 44);

        System.out.println("ArrayList after Update: " + getSetDemo);



        System.out.println("------------------------Iterator------------------");

        ArrayList<Integer> list2 = new ArrayList<Integer>(); // clear arraylist
        int[] x = {1, -1, 2, -2, 3, -3, 4, -4, -1};

        for (int i : x) {
            list2.add(i);
        }

        System.out.println("Print before Iterator: " + list2);

        Iterator<Integer> iterator = list2.iterator();

        while (iterator.hasNext()) {
            Integer z = (Integer) iterator.next();
            if (z.intValue() < 0)
                iterator.remove(); // will remove all negative values
        }
        System.out.println(list2);


        System.out.println("-------------converting ArrayList to array-----------------");

        Object o[] = list2.toArray();

        for (int i = 0; i < o.length; i++) {
            Integer z = (Integer) o[i];
            System.out.print(z.intValue() + " ");
        }

        System.out.println();

        for (Integer i : list2) {
            System.out.println(i.intValue()); // converts Wrapper to primary Data Type
            System.out.println(i);
        }


        System.out.println(
                "------------- adding ArrayList's own reference to ArrayList---------------");

        ArrayList<ArrayList> multiDimList = new ArrayList<>();

        System.out.println(multiDimList.size());

        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);

        System.out.println(multiDimList.size());

        System.out.println(multiDimList); // OP: [(this Collection), (this Collection), (this
                                          // Collection), (this Collection)]


        System.out.println(
                "------------- adding ArrayList's own reference to ArrayList-----------------");

        ArrayList<ArrayList> multiDimList2 = new ArrayList<ArrayList>();
        ArrayList<String> arrayListString = new ArrayList<String>();

        System.out.println(multiDimList2.size());

        arrayListString.add("a");
        arrayListString.add("b");
        arrayListString.add("c");

        multiDimList2.add(arrayListString);

        System.out.println(multiDimList2.size());

        System.out.println(multiDimList2); // OP: [[a, b, c]]


        System.out.println("----------add method-------------");
        ArrayList<String> addDemoList = new ArrayList<>();

        addDemoList.add("Hi");
        addDemoList.add("Hello");
        addDemoList.add("String");
        addDemoList.add("Test");

        System.out.println(addDemoList);

        addDemoList.add(3, "lalu");

        System.out.println(addDemoList);

        addDemoList.add(0, "Bye");

        System.out.println("Elements after adding bye:" + addDemoList);

        System.out.println("-------------------ArrayList to array----------------------");

        ArrayList<String> demoListToArray = new ArrayList<>();
        demoListToArray.add("String1");
        demoListToArray.add("String2");
        demoListToArray.add("String3");
        demoListToArray.add("String4");

        // ArrayList to array conversion
        String[] stringArray = new String[demoListToArray.size()];

        for (int j = 0; j < demoListToArray.size(); j++) {
            stringArray[j] = demoListToArray.get(j);
        }

        for (String k : stringArray) {
            System.out.println(k);
        }

        // using Stream
        stringArray = demoListToArray.stream().toArray(String[]::new); // shorthand of
                                                                       // `.toArray(size -> new
                                                                       // String[size])`

        Arrays.stream(stringArray).forEach(System.out::println);



        System.out.println("--------------Array to ArrayList------------------");

        String cityNames[] = {"Agra", "Meerut", "Lucknow", "Delhi"};

        List<String> I = Arrays.asList(cityNames); // to List

        ArrayList<String> cityList = new ArrayList<>(Arrays.asList(cityNames));


        System.out.println("ArrayList Comparison");



        System.out.println("--------------ArrayList comparison----------------");

        ArrayList<String> compareList1 = new ArrayList<>();

        compareList1.add("Hi!");
        compareList1.add("How are you?");
        compareList1.add("Good Morning");
        compareList1.add("bye");
        compareList1.add("Good Night");

        ArrayList<String> compareList2 = new ArrayList<>();

        compareList2.add("Howdy");
        compareList2.add("Good Morning");
        compareList2.add("bye");
        compareList2.add("Good Night");

        // storing the comparison o/p in ArrayList<String>
        ArrayList<String> compStore = new ArrayList<>();
        for (String temp : compareList1) {
            compStore.add(compareList2.contains(temp) ? "Yes" : "No");
        }
        System.out.println(compStore);

        // storing the comparison o/p in ArrayList<Integer>
        ArrayList<Integer> compStoreInt = new ArrayList<>();
        for (String temp : compareList1) {
            compStoreInt.add(compareList2.contains(temp) ? 1 : 0);
        }
        System.out.println(compStoreInt);


        System.out.println("-------------Ensure Capacity------------------");
        /*
         * ArrayList<String> al = new ArrayList<>(4); al.ensureCapacity(76);
         */


        System.out.println("-----------------Synced ArrayList--------------");
        List<String> syncedList = Collections.synchronizedList(new ArrayList<>()); // can give `new
                                                                                   // ArrayList<String>()`
                                                                                   // as argument

        syncedList.add("Pen");
        syncedList.add("Notebook");
        syncedList.add("Ink");

        System.out.println("Iterating synced ArrayList");

        Iterator<String> iterator2 = syncedList.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("----------------Trim ArrayList------------------");
        ArrayList<Integer> trimArrayList = new ArrayList<>(50); // ArrayList don't have capacity or
        // Vector<Integer> trimArrayList = new Vector<>(50);

        // System.out.println(trimArrayList.capacity()); // works only with Vector

        trimArrayList.add(1);
        trimArrayList.add(2);
        trimArrayList.add(3);
        trimArrayList.add(4);

        trimArrayList.trimToSize();

        // System.out.println(trimArrayList.capacity()); // works only with Vector
        System.out.println(trimArrayList);


        System.out.println("----------------ArrayList to List------------------");

        ArrayList<String> arrayListToArrayEx = new ArrayList<>();
        arrayListToArrayEx.add("First");
        arrayListToArrayEx.add("Second");
        arrayListToArrayEx.add("Third");
        arrayListToArrayEx.add("Random");

        System.out.println("Actual ArrayList: " + arrayListToArrayEx);

        String[] strArr = new String[arrayListToArrayEx.size()];

        arrayListToArrayEx.toArray(strArr);

        System.out.println("created array content: ");
        Arrays.stream(strArr).forEach(System.out::println);


        System.out.println("-----------Reverse ArrayList---------------");

        ArrayList<String> reverseArrayListEx = new ArrayList<>();

        reverseArrayListEx.add("First");
        reverseArrayListEx.add("Second");
        reverseArrayListEx.add("Third");
        reverseArrayListEx.add("Random");
        System.out.println("Actual ArrayList: " + reverseArrayListEx);

        Collections.reverse(reverseArrayListEx);
        System.out.println("Result after reverse operation ArrayList: " + reverseArrayListEx);



        System.out.println("--------------Shuffle List-----------------");

        ArrayList<String> shuffleArrayListEx = new ArrayList<>();

        shuffleArrayListEx.add("First");
        shuffleArrayListEx.add("Second");
        shuffleArrayListEx.add("Third");
        shuffleArrayListEx.add("Random");
        System.out.println("Before Shuffle ArrayList: " + shuffleArrayListEx);

        Collections.shuffle(shuffleArrayListEx);
        System.out.println("Result after shuffle operation ArrayList: " + shuffleArrayListEx);

        Collections.shuffle(shuffleArrayListEx);
        System.out
                .println("Result after second shuffle operation ArrayList: " + shuffleArrayListEx);



        System.out.println("--------------Sub-Range List-----------------");

        ArrayList<String> subRangeArrayListEx = new ArrayList<>();

        subRangeArrayListEx.add("First");
        subRangeArrayListEx.add("Second");
        subRangeArrayListEx.add("Third");
        subRangeArrayListEx.add("Random");
        subRangeArrayListEx.add("click");
        System.out.println("Before Shuffle ArrayList: " + subRangeArrayListEx);


        System.out.println("sub-list: " + subRangeArrayListEx.subList(2, 4)); // toIndex is not
                                                                              // inclusive

        System.out.println("--------------Swap Elements-----------------");

        ArrayList<String> swapElementsEx = new ArrayList<>();

        swapElementsEx.add("First");
        swapElementsEx.add("Second");
        swapElementsEx.add("Third");
        swapElementsEx.add("Random");
        swapElementsEx.add("click");
        System.out.println("Before Shuffle ArrayList: " + subRangeArrayListEx);

        Collections.swap(swapElementsEx, 2, 4);
        System.out.println("List after swapping: " + swapElementsEx); // toIndex is inclusive



        System.out.println("----------------containsAll()--------------------------------");

        ArrayList<String> containsAllList1 = new ArrayList<>(
                Stream.of("First", "Second", "Third", "Random").collect(Collectors.toList()));
        ArrayList<String> containsAllList2 = new ArrayList<>(Arrays.asList("Second", "Random"));

        System.out.println("Does arraylist contains all list elements? "
                + containsAllList1.containsAll(containsAllList2));

        containsAllList2.add("One");

        System.out.println("Does arraylist contains all list elements? "
                + containsAllList1.containsAll(containsAllList2));
    }
}
