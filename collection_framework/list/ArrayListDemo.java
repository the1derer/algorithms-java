package collection_framework.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {

        System.out.println("----------------Demoing adding and removing element-----------------");

        ArrayList<String> list1 = new ArrayList<>();

        // ArrayList list = new ArrayList(); // non-generic version

        list1.add("d");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("b");

        // list.add(Integer.valueOf(10)); // works in case of non-generics ArrayList, also note here we are able to add 'Integer' to an String ArrayList, which shouldn't have happened

        System.out.println(list1.size());
        System.out.println(list1);

        list1.remove(2); // removing 'c'

        System.out.println(list1.size());
        System.out.println(list1);


        System.out.println("------------------------Demoing Iterator------------------");

        ArrayList<Integer> list2 = new ArrayList<Integer>(); // clear arraylist
        int[] x = {1, -1, 2, -2, 3, -3, 4, -4, -1};

        for(int i : x) {
            list2.add(i);
        }

        System.out.println("Print before Iterator: " + list2);

        Iterator<Integer> iterator = list2.iterator();

        while(iterator.hasNext()) {
            Integer z = (Integer) iterator.next();
            if(z.intValue() < 0)
                iterator.remove(); // will remove all negative values
        }
        System.out.println(list2);


        System.out.println("-------------Demo converting ArrayList to array-----------------");

        Object o[] = list2.toArray();
        
        for(int i = 0; i < o.length; i++) {
            Integer z = (Integer) o[i];
            System.out.print(z.intValue() + " ");
        }

        System.out.println();

        for(Integer i : list2) {
            System.out.println(i.intValue()); // converts Wrapper to primary Data Type
            System.out.println(i);
        }


        System.out.println("-------------Demo adding ArrayList's own reference to ArrayList---------------");
        
        ArrayList<ArrayList> multiDimList = new ArrayList<>();

        System.out.println(multiDimList.size());

        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);
        multiDimList.add(multiDimList);

        System.out.println(multiDimList.size());

        System.out.println(multiDimList); // OP: [(this Collection), (this Collection), (this Collection), (this Collection)]

        
        System.out.println("-------------Demo adding ArrayList's own reference to ArrayList-----------------");

        ArrayList<ArrayList> multiDimList2 = new ArrayList<ArrayList>();
        ArrayList<String> arrayListString = new ArrayList<String>();

        System.out.println(multiDimList2.size());

        arrayListString.add("a");
        arrayListString.add("b");
        arrayListString.add("c");

        multiDimList2.add(arrayListString);

        System.out.println(multiDimList2.size());

        System.out.println(multiDimList2); // OP: [[a, b, c]]

        
        System.out.println("----------Demoing add method-------------");
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
    }
}
