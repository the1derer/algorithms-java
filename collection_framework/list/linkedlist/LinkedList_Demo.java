package list.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList_Demo {
    
    public static void main(String[] args) {

        System.out.println("---------Simple initialize and print---------------");

        LinkedList<String> simpleOpertDemoList = new LinkedList<String>();

        simpleOpertDemoList.add("Item 1");
        simpleOpertDemoList.add("Item 5");
        simpleOpertDemoList.add("Item 1");
        simpleOpertDemoList.add("Item 3");
        simpleOpertDemoList.add("Item 6");
        simpleOpertDemoList.add("Item 2");

        System.out.println("Linked List content: " + simpleOpertDemoList);

        System.out.println("---------add(/remove)First and add(/remove)Last---------------");

        simpleOpertDemoList.addFirst("First Item");
        simpleOpertDemoList.addLast("Last item");

        System.out.println("Linked List after addFirst and and addLast :" + simpleOpertDemoList);

        System.out.println("-------------get() & set()-------------");

        Object firstVar = simpleOpertDemoList.get(0);
        System.out.println("First element: " + firstVar);
        
        simpleOpertDemoList.set(0, "changed first item");
        System.out.println("First element after updating: " + simpleOpertDemoList.get(0));
        System.out.println("First element after updating: " + simpleOpertDemoList.getFirst());

        simpleOpertDemoList.set(simpleOpertDemoList.size()-1, "changed last item");
        System.out.println("Last element after updating: " + simpleOpertDemoList.get(simpleOpertDemoList.size()-1));
        System.out.println("Last element after updating: " + simpleOpertDemoList.getLast());


        System.out.println("-------------removeFirst() and removeLast()-------------------");

        simpleOpertDemoList.removeFirst();
        simpleOpertDemoList.removeLast();

        System.out.println("LinkedList after removal of first and last element: " + simpleOpertDemoList);


        System.out.println("---------------add and remove remove from a position------------------");
        
        simpleOpertDemoList.add(0, "Newly added item");
        simpleOpertDemoList.remove(2);

        System.out.println("After add() and remove(): " + simpleOpertDemoList);

        System.out.println("----------------getFirst() and getLast()----------------------");

        System.out.println("getFirst(): " + simpleOpertDemoList.getFirst());
        System.out.println("getLast(): " + simpleOpertDemoList.getLast());


        System.out.println("------------------iterating LinkedList ----------------------");

        System.out.println("**using for loop**");
        for(int num = 0; num < simpleOpertDemoList.size(); num++) {
            System.out.println(simpleOpertDemoList.get(num));
        }

        System.out.println("**Enhanced for loop(also called for-each loop)**");  // NOTE: for-each loop internally uses a iterator
        for(String str : simpleOpertDemoList) {
            System.out.println(str);
        }

        System.out.println("**while loop**");
        int num = 0;
        while(simpleOpertDemoList.size() > num) {
            System.out.println(simpleOpertDemoList.get(num)); // very inefficient as internally get(index) has to run a while loop as well.
            num++;
        }

        System.out.println("**Iterator**");
        Iterator<String> iterator = simpleOpertDemoList.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("**Reverse Iterator**");
        Iterator<String> reverseIterator = simpleOpertDemoList.descendingIterator();
        while(reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }


        System.out.println("---------------------remove methods-----------------------");

        LinkedList<String> removeDemoList = new LinkedList<>(Arrays.asList("First", "Second", "Third", "first", "random", "Four", "Five", "six", "seven", "eight", "nine", null,  "eight"));

        System.out.println(removeDemoList);

        System.out.println("remove() method: " + removeDemoList.remove()); // removes first element
        System.out.println("after remove() method: " + removeDemoList);

        System.out.println("remove(index) method: " + removeDemoList.remove(2));
        System.out.println("After remove(index) method: " + removeDemoList);

        System.out.println("remove(object) method: " + removeDemoList.remove("six"));
        System.out.println(removeDemoList);

        System.out.println("removeFirst() method: " + removeDemoList.removeFirst());
        System.out.println(removeDemoList);

        System.out.println("remove(index) method: " + removeDemoList.remove(2));
        System.out.println("After remove(index) method: " + removeDemoList);

        System.out.println("removeFirst() method: " + removeDemoList.removeFirst());
        System.out.println(removeDemoList);

        System.out.println("remove(index) method: " + removeDemoList.removeLastOccurrence("eight"));
        System.out.println("After remove(index) method: " + removeDemoList);


        System.out.println("---------------------push(), pop() & peek()-----------------------");

        LinkedList<String> peekPushPopDemo = new LinkedList<>();

        peekPushPopDemo.addAll(Arrays.asList("First", "Second", "Third", "Random"));

        System.out.println("Last Element: " + peekPushPopDemo.getLast()); // throws Exception if no element in list
        System.out.println("Last Element: " + peekPushPopDemo.getLast()); // throws Exception if no element in list
        System.out.println("Last Element: " + peekPushPopDemo.peekLast()); // returns null if there is no element in the list
        System.out.println("Last Element: " + peekPushPopDemo.peekFirst()); // returns null if there is no element in the list

        peekPushPopDemo.push("Push Element");
        System.out.println("After push operation: " + peekPushPopDemo);

        peekPushPopDemo.pop();
        System.out.println("After pop operation: " + peekPushPopDemo);
        
    }
}
