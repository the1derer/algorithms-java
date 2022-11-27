package collection_framework.navigableset;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Iterator;

public class NavigableSetDemo {

    public static void main(String[] args) {
        NavigableSet<String> navigableSet = new TreeSet<>(Arrays.asList("X", "B", "A", "Z", "T", "D", "S"));
        
        System.out.println("------------------Ascending and Descending Iterator--------------");
        Iterator<String> ascendingIterator = navigableSet.iterator();
        System.out.println("Original Set using Ascending iterator: ");
        while(ascendingIterator.hasNext()) {
            System.out.print(ascendingIterator.next() + " ");
        }

        System.out.println();

        Iterator<String> descIterator = navigableSet.descendingIterator();
        System.out.println("Original Set using descending iterator: ");
        while(descIterator.hasNext()) {
            System.out.print(descIterator.next() + " ");
        }


        System.out.println("-------------Descending Order set--------------");
        System.out.println("Descending order navigable Set: " + navigableSet.descendingSet());


        System.out.println("-------------------ceiling(), floor()-------------------");
        System.out.println("Least element in Navigable Set greater than or equals to M: " + navigableSet.ceiling("M"));

        System.out.println("Greatest element in Navigable Set less than or equals to M: " + navigableSet.floor("M"));

        System.out.println("-------------------headSet(), tailSet(), subSet()-------------------");
        System.out.printf("Head Set : %s%n", navigableSet.headSet("X"));

        System.out.printf("Tail Set range inclusive : %s%n", navigableSet.tailSet("T"));
        System.out.printf("Tail Set range exclusive  : %s%n", navigableSet.headSet("T", false));

        System.out.printf("Sub Set : %s%n", navigableSet.subSet("B", true, "X", true));


        System.out.println("-------------------first(), last()-------------------");
        System.out.printf("FirstElement : %s%n", navigableSet.first());
        System.out.printf("Last Element : %s%n", navigableSet.last());

        System.out.printf("Original Set : %s%n", navigableSet);


        System.out.println("-------------------pollFirst(), pollLast()-------------------");
        System.out.printf("FirstElement : %s%n", navigableSet.pollFirst());
        System.out.printf("Last Element : %s%n", navigableSet.pollLast());

        System.out.printf("Reverse Set after pollFirst() and pollLast() : %s%n", navigableSet.descendingIterator());
        
    }
}
