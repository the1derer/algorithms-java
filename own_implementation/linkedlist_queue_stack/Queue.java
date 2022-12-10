package own_implementation.linkedlist_queue_stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Queue() {}

    public Queue(T firstElem) {
        offer(firstElem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    
    public T peek()  {
        return list.getFirst();
    }

    public T poll() {
        return list.removeFirst();
    }

    public void offer(T data) {
        list.addLast(data);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    
}
