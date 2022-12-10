package own_implementation.linkedlist_queue_stack;

import java.util.Queue;
import javax.management.RuntimeErrorException;

// TODO: implement with 'head' and 'tail' pointer. Check Example in Will Fiset's repo
public class ArrayBasedCircularQueue<T> implements Iterable<T> {
    private T[] array;
    int size;
    private static final int DEFAULT_CAPACITY = 1 << 3;

    public ArrayBasedCircularQueue(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Argument: " + capacity);
        this.array = (T[]) new Object[capacity];
    }

    public ArrayBasedCircularQueue(T firstElem) {
        this(DEFAULT_CAPACITY);
        array[size++] = firstElem;
    }

    public ArrayBasedCircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (size == 0)
            throw new RuntimeException("queue is empty");
        return array[size - 1];
    }

    public void offer(T data) {
        if(size == array.length) throw new RuntimeException("Queue is Full");
        array[size++] = data;        
    }

    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        T[] newArr = (T[]) new Object[size-1];
        T retData = array[0];
        for(int i = 1; i < size; i ++)
            newArr[i-1] = array[i];
        array = newArr;
        --size;
        return retData;
    }

}
