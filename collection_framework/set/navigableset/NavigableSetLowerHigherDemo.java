package collection_framework.set.navigableset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetLowerHigherDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 4, 1, 5);

        // NavigableSet<? extends Number> navigableSet = new TreeSet<Integer>(list); // TODO: See why this is not working
        NavigableSet<Integer> navigableSet = new TreeSet<Integer>(list);

        System.out.println("Ascending order(default): " + navigableSet);

        Iterator<Integer> descIterator = navigableSet.descendingIterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(descIterator.hasNext()) {
            stringBuilder.append(descIterator.next());
        }
        System.out.println(stringBuilder);

        System.out.println("Lower of 3: " + navigableSet.lower(3));

        System.out.println("Higher of 3: " + navigableSet.higher(3));

    }
}
