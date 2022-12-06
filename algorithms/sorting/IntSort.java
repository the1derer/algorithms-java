package algorithms.sorting;

import java.util.Arrays;

public class IntSort {

    public static int[] bubbleSort(int[] intArray) {
        if (intArray == null || intArray.length == 0)
            throw new RuntimeException("can't sort an empty array");
        
        return null;
    }

    static void printArray(int[] array) {
        Arrays.stream(array).forEach(i -> System.out.print(i + ", "));
    }
}

class IntSortDemo {
    public static void main(String[] args) {
        
        int[] array = {3, 4, 5, 1, 90, 43, -5, -100, 0};
        IntSort.printArray(array);

        // int[] bubbleSortedArray = IntSort.bubbleSort(array);
        // IntSort.printArray(bubbleSortedArray);

        // int[] selectionSortedArray = IntSort.selectionSort(array);
        // IntSort.printArray(selectionSortedArray);

        // IntSort intSortObj = new IntSort();
        // int[] insertionSortedArray = intSortObj.insertionSort(array);
        // IntSort.printArray(insertionSortedArray);

        // int[] quickSortedArray = IntSort.quickSort(array);
        // IntSort.printArray(quickSortedArray);

        // IntSort.printArray(array);

        // IntSort.mergeSort(array); // sorting array in-place i.e. not creating a new array
        // IntSort.printArray(array);

    }
}