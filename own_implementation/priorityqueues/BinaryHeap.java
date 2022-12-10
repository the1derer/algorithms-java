package own_implementation.priorityqueues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * PriorityQueues using Binary Heap
 */
public class BinaryHeap<T extends Comparable<T>> {

    // The number of elements currently inside the heap
    private int heapSize;

    // The internal capacity of the heap
    private int heapCapacity;

    private List<T> heap;

    // Map to track indices of a particular node value
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public BinaryHeap() {
        this(1);
    }

    public BinaryHeap(int size) {
        heap = new ArrayList<>(size);
    }

    // TODO: comeback and redo this after learning HeapSort
    // construct a priority queue using heapify in O(n) time
    public BinaryHeap(T[] elements) {

        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);

        // Place all elements in heap
        for (int i = 0; i < heapSize; i++) {
            mapAdd(elements[i], i);
            heap.add(elements[i]);
        }

        // heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i++) {
            sink(i);
        }
    }

    // Priority queue construction, O(n log(n))
    public BinaryHeap(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    public int size() {
        return heapSize;
    }

    // Returns the value of the element with the lowest priority
    public T peek() {
        if (isEmpty())
            return null;
        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T element) {
        if (element == null)
            return false;
        return map.containsKey(element);

        // Linear scan to check containment, O(n)
        // for (int i = 0; i < heapSize; i++) {
        // if(heap.get(i).equals(element)) {
        // return true;
        // }
        // }
        // return false;
    }

    // Add an element to priority
    public void add(T element) {
        if (element == null)
            throw new IllegalArgumentException();

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

    // Test if the value of node i <= node j
    // This method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // Bottom up node swim, O(log n)
    private void swim(int k) {

        // Grab the index of the next parent node WRT to 'k'
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);

            k = parent;

            // grab the index of the next parent node WRT to new k
            parent = (k-1) / 2;
        }

    }
}
