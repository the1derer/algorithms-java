package datastructures.priorityqueues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * BinaryHeap
 */
public class BinaryHeap<T extends Comparable<T>> {

    // number of elements currently inside the heap
    private int heapSize; // = 0;

    // The internal capacity of the heap
    private int heapCapacity; // = 0;

    // Dynamic list to track the elements inside heap
    private List<T> heap;

    // map to keep track of the possible indices of a particular value.
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public BinaryHeap() {
        this(1);
    }

    // construct a priority queue with an initial capacity
    public BinaryHeap(int capacity) {
        heap = new ArrayList<>(capacity);
    }

    // construct a priority queue using heapify in O(n) time
    public BinaryHeap(T[] elements) {
        heapSize = heapCapacity = elements.length;

        for (int i = 0; i < heapSize; i++) {
            mapAdd(elements[i], i);
            heap.add(elements[i]);
        }

        // TODO: learn why heapify process is linear process instead of logarithmic time
        // heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i++) {
            sink(i);
        }
    }

    // Priority queue construction O(n log n)
    public BinaryHeap(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    // clear everything inside the heap, O(n)
    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    // return size of the heap
    public int size() {
        return heapSize;
    }

    // returns the value of the element with the highest priority in priority queue.
    public T peek() {
        if (isEmpty())
            return null;
        return heap.get(0);
    }

    // removes the root of the heap, O(log n)
    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T element) {

        // `Map` lookup to check containment, O(1)
        // According to Will Fiset: Using `Map` adds a lot of overhead, so if you are
        // not removing a lot of elements then using `Map` is not worth it.
        if (element == null)
            return false;
        return map.containsKey(element);

        // Linear scan to check containment, O(n)
        // for (int i = 0; i < heapSize; i++) {
        // if (heap.get(i).equals(element)) {
        // return true;
        // }
        // }
        // return false;
    }

    // Adds an element to the priority queue, the element must not be null, O(log n)
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Priority queue can't have null elements");
        }

        if (heapSize < heapCapacity) {
            heap.set(heapSize, element);
        } else {
            heap.add(element);
            heapCapacity++;
        }

        mapAdd(element, heapSize);

        swim(heapSize);
        heapSize++;
    }

    // Tests if the value of node i <= node j
    // assumes i & j are valid indices, O(1)
    public boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        return node1.compareTo(node2) <= 0;
    }

    // Bottom up node swim, O(log n)
    private void swim(int k) {
        // grab the index of the next parent node WRT k
        int parent = (k - 1) / 2; // TODO: not able to understand why left and right condition has same parent
                                  // formula.

        // keep bubbling up while we have not reached the root and while we're less than
        // our parent.
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;

            // grab the index of the next parent WRT k
            parent = (k - 1) / 2;
        }
    }

    // Top down node sink, O(log n)
    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left; // Assume left is the smallest node of the 2 children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            // stop if we're outside the bounds of the tree or stop early if we can't sink k
            // anymore
            if (left >= heapSize || less(k, smallest))
                break;

            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int i, int j) {
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);

        heap.set(i, j_elem);
        heap.set(j, i_elem);

        mapSwap(i_elem, j_elem, i, j);
    }

    // removes a particular element in the heap, O(log n)
    public boolean remove(T element) {
        if (element == null)
            return false;

        // Linear removal via search, O(n)
        // for (int i = 0; i < heapSize; i++) {
        // if (element.equals(heap.get(i))) {
        // removeAt(i);
        // return true;
        // }
        // }
        // return false;

        // logarithmic removal map, O(log n)
        Integer index = mapGet(element);
        if (index != null)
            removeAt(index);
        return index != null;
    }

    // removes a node at particular index, O(log n)
    private T removeAt(int i) {
        if (isEmpty())
            return null;

        heapSize--;

        T removed_data = heap.get(i);
        swap(i, heapSize);

        // obliterate the value
        heap.set(heapSize, null);
        mapRemove(removed_data, heapSize);

        // remove last element
        if (i == heapSize)
            return removed_data;

        T elem = heap.get(i);

        // try sinking element
        sink(i);

        // if sinking didn't work try swimming
        if (heap.get(i).equals(elem)) {
            swim(i);
        }

        return removed_data;
    }

    // recursively checks if this heap is a mean heap
    // this method is just for testing purposes to make sure that the heap invariant
    // is still being maintained.
    // call this method with k=0 to start at the root
    public boolean isMinHeap(int k) {
        // if we are outside the bounds of heap return true
        if (k >= heapSize)
            return true;

        int left = 2 * k + 1;
        int right = 2 * k + 1;

        // make sure the current node k is less than both of its children if they exist.
        // return false otherwise to indicate invalid heap

        if (left < heapSize && !less(k, left)) return false;
        if (left < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    private void mapAdd(T value, int index) {
        TreeSet<Integer> set = map.get(value);

        // new value being inserted in map
        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);

        // value already exists in map
        } else set.add(index); 
    }

    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        set.remove(index); // TreeSet take O(log n) removal time

        if(set.size() == 0) map.remove(value);
    }

    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        return set != null ? set.last() : null;
    }

    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    @Override public String toString() {
        return heap.toString();
    }

}
