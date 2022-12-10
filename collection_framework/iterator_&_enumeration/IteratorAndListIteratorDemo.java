import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


class IteratorDemo {

    public static void main(String[] args) {
        String removeElem = "Perl";

        List<String> myList = new ArrayList<String>(Arrays.asList("Java", "Unix", "Oracle", "C++", "Perl", "Perl", "Perl"));

        System.out.println("Before remove() : " + myList);

        Iterator<String> itr = myList.iterator();

        while (itr.hasNext()) {
            if(removeElem.equals(itr.next())) {
                itr.remove();
            }
        }

        System.out.println("After remove: " + myList);
    }
    
}


class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> listIteratorDemoList = new ArrayList<>(Arrays.asList(23, 98, 29, 71, 5));

        ListIterator<Integer> listIterator = listIteratorDemoList.listIterator();

        System.out.println("Elements in forward direction: ");
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }

        System.out.println(); //

        System.out.println("Elements in backward direction: ");
        while(listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
    }
}