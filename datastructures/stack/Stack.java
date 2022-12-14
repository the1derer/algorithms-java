package datastructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Stack
 */
// TODO: add empty stack checks
public class Stack<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Stack() {};
    public Stack(T firstElem) {
        push(firstElem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(T data) {
        list.addLast(data);
    }

    public T pop() {
        return list.removeLast();
    }

    public T peek() {
        return list.getLast();
    }

    public Iterator<T> iterator() {
        return list.iterator();
        // return new Iterator<T>() {
            
        //     @Override
        //     public boolean hasNext() {
        //         return !list.isEmpty();
        //     }

        //     @Override
        //     public T next() {
        //         return pop();
        //     }
        // };
    }
    
}