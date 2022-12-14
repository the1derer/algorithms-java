package datastructures.dynamicarray;

import java.util.Iterator;

/**
 * DynamicArray
 */
public class DynamicArray<T> implements Iterable<T> {

    private T[] internalArray;

    private int size = 0;
    private int capacity = 0;

    private static final int DEFAULT_CAPACITY = 1 << 4;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity:" + capacity);
        // TODO: Check why I am not able to add this annotation here
        // @SuppressWarnings("unchecked")
        this.internalArray = (T[]) new Object[capacity];
    }

    // private void arrayCopy() {
    // T[] currentArray = this.internalArray;
    // }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return capacity;
    }

    public T get(int index) {
        return internalArray[index];
    }

    public void set(int index, T value) {
        internalArray[index] = value;
    }

    public void add(T value) {
        add(size - 1, value);
    }

    public void add(int index, T value) {
        if (size + 1 >= capacity) {
            capacity *= 2;
        }
        T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            new_arr[i] = internalArray[i];
        }
        internalArray = new_arr;
        internalArray[size++] = value;
    }

    // TODO: Still not clear of the logic
    public T removeAt(int rm_index) {
        if(rm_index < 0 || rm_index >= size) throw new IllegalArgumentException("Illegal Argument: " + rm_index);
        T data = internalArray[rm_index];
        T[] new_arr = (T[]) new Object[size-1];
        for(int i = 0, j =0; j < size; i++, j++) {
            if(i == rm_index) j--;
            else new_arr[j] = internalArray[i];
        }
        internalArray = new_arr;
        capacity = --size;
        return data;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (internalArray[i].equals(obj))
                return -1;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index > size;
            }

            @Override
            public T next() {
                return internalArray[index++];
            }
        };

    }


}
