package list.vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/*
 * Vector is synced and can be seen both by Iterator and Enumeration.
 * 
 * Constructors:
 * 1. Vector()
 * 2. Vector(int capacity)
 * 3. Vector(Collection c)
 * 4. Vector(int capacity, int increment)
 */

public class VectorAndEnumerationDemo {

    public static void main(String[] args) {
        
        Vector<String> vector = new Vector<>(3, 2);

        System.out.println("Initial capacity: " + vector.capacity());
        System.out.println("Initial Size: " + vector.size());

        vector.addAll(Arrays.asList("a", "b", "a", null, "b"));

        System.out.println("Capacity after addAll() : " + vector.capacity());
        System.out.println("Size after addAll() : " + vector.size());

        vector.removeElementAt(2);

        Enumeration<String> enumeration = vector.elements();

        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        System.out.println("vector capacity before trimming: " + vector.capacity());
        vector.trimToSize();
        System.out.println("vector capacity before trimming: " + vector.capacity());

        System.out.println(vector); // printing directly

        vector.forEach(System.out::println);

        vector.stream() // checking stream creation from vector
            .filter(i -> i != null)
            .map(i -> i+1)
            .forEach(System.out::println);
        
    }

        
}
