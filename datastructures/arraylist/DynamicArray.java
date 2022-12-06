package datastructures.arraylist;

import java.util.Iterator;

@SuppressWarnings({"uncheked"}) // because of generics
public class DynamicArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAP = 1 << 3; // shift operator, here 1 will be shifted by 3
                                                   // bits making it 2^3 from 2^0.

    private T[] array;
    private int capacity = 0;
    private int length = 0;

    DynamicArray() {
        this(DEFAULT_CAP);
    }

    DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        // array = new T[capacity];
        array = (T[])new Object[capacity];
    }

    DynamicArray(T[] arr) { // given an static array make it dynamic array
        if (arr == null)
            throw new IllegalArgumentException("Array can't be null");
        // array = java.util.Arrays.copyOf(arr, array.length);
        // for(int i=0; i<)
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T elem) {
        array[index] = elem;
    }

    public void add(T elem) { // add at the last of list
        
    }

    public void add(T value, int index) {
        if (index < 0 || index >= length)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    }

    // TODO: implement this
    // public T remove(index) {

    // }

    @Override
    public String toString() {
        if (length == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++)
                sb.append(array[i] + ", ");
            return sb.append(array[length - 1] + "]").toString();
        }
    }

    // binarySearch
    public int binarySearch(T key) {
        return java.util.Arrays.binarySearch(array, 0, length, key);
    }

    // sort this array
    public void sort() {
        java.util.Arrays.sort(array, 0, length);
    }

    public void reverse() {
        for(int i = 0; i < array.length/2; i++) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                // this.remove(index);
            }
            
        };
    }
    @Override
    public boolean equals(Object compare) {
        if(!(compare instanceof DynamicArray<?>))
            return false;
        DynamicArray<T> arrayList = (DynamicArray<T>)compare;
        if(this.size() != arrayList.size()) {
            return false;
        }
        for(int i = 0 ; i < this.size(); i++) {
            if(this.get(i) != arrayList.get(i))
                return false;
        }
        return true;
    }
}
