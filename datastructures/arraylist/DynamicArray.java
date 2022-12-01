package arraylist;

public class DynamicArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAP = 1 << 3; // shift operator, here 1 will be shifted by 3 bits making it 2^3 from 2^4.

    private T[] array;
    private int capacity = 0;
    private int length = 0;

    DynamicArray() {
        this(DEFAUlT_CAP);
    }

    DynamicArray(int capacity) {
        if(capacity <0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        array = new T[capacity];
    }

    DynamicArray(T[] arr) { // given an static array make it dynamic array
        if(arr == null) throw new IllegalArgumentException("Array can't be null");
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

    public void add(T elem) {
        if(length+1 >= apacity) {
            if(capacity==0) capacity = 1;
            else cpa
        }
    }

    public boolean add(T value) { // add after the last position
        add(value, length-1);
    }

    public boolean add(T value, int index) {
        if(index < 0 ||  index >= length) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        array = new T[capacity];
    }

    @Override
    public String toString() {
        if(length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for(int i=0; i < length - 1; i++) sb.append(array[i] + ", ");
            return sb.append(array[length-1] + "]").toString();
        }
    }

    //binarySearch
    public int binarySearch(T key) {
        return java.util.Arrays.binarySearch(array, 0, length, key);
    }

    //sort this array
    public void sort() {
        java.util.Arrays.sort(array, 0, length);
    }

    // TODO: implement this
    @Override
    public boolean equals(DynamicArray compare) {
    }
}
