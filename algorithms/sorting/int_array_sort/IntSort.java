package algorithms.sorting.int_array_sort;

import java.util.Arrays;

public class IntSort {

    public static int[] selectionSort(int[] intArray) {
        /*
         * Steps:- 1. Find(or select) smallest element
         * 2. Swapping it with first element for ascending order.
         */
        // printArray(intArray);

        int N = intArray.length;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minValIndex = -1;

            for (int j = i; j < N; j++) {
                if (intArray[j] <= min) {
                    min = intArray[j];
                    minValIndex = j;
                }
            }

            // swap(intArray[i], intArray[minValIndex]); // Doesn't swap: since java doesn't have call by reference
            int temp = intArray[i];
            intArray[i] = intArray[minValIndex];
            intArray[minValIndex] = temp;

            System.out.printf("Array after step-%d: ", i + 1);
            printArray(intArray);
            System.out.println();
        }

        return intArray;

    }

    

    public static void bubbleSort(int[] intArray) {

        if (intArray == null || intArray.length == 0)
            throw new RuntimeException("can't sort an empty array");
        
        /*
         * Steps:-
         * we iterated 'i' only N -1 times instead of N times coz after N - 1 the second smallest element will be at its place, hence the smallest will also be at its place
         * i : N - 1 
         *     j : 
         */
        for (int i = 0; i < intArray.length - 1; i++) { 
            for (int j = 0; j < intArray.length - 1 - i; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    swap(intArray, j + 1, j);
                }
            }
            
            System.out.printf("Array after step-%d: ", i + 1);
            printArray(intArray);
            System.out.println();
        }
    }

    public void insertionSort(int[] intArray) {
        // idea: insert a new element at its desired index in an already sorted array.

        int N = intArray.length;

        for (int i = 0; i < N - 1; i++) {

            // using for loop
            // for (int j = i + 1; j > 0; j--) {
            //     if (intArray[j] < intArray[j - 1]) {
            //         swap(intArray, j, j - 1);
            //     } else {
            //         break;
            //     }
            // }

            // using while loop
            int j = i + 1;
            while (j > 0 && intArray[j] < intArray[j - 1]) {
                swap(intArray, j, j - 1);
                j--;
            }

            System.out.printf("Array after step-%d: ", i + 1);
            printArray(intArray);
            System.out.println();
        }

    }


    //---------Utility Functions--------

    // private static void swap(int a, int b) {
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] array) {
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }
}


class IntSortDemo {
    public static void main(String[] args) {

        int[] array = {90, 43, 5, 4, 3, 1, 0, -5, - 100, 5, 2}; //{3, 4, 5, 1, 90, 43, -5, -100, 0};
        IntSort.printArray(array);

        // System.out.println("\n---Sorting using selection-sort---");
        // IntSort.selectionSort(array);

        // System.out.println("\n---Sorting using bubble-sort---");
        // IntSort.bubbleSort(array);

        
        System.out.println("\n---Sorting using insertion-sort---");
        IntSort intSortObj = new IntSort();
        intSortObj.insertionSort(array);

        // int[] quickSortedArray = IntSort.quickSort(array);

        // IntSort.printArray(array);

        // IntSort.mergeSort(array); // sorting array in-place i.e. not creating a new array
        // IntSort.printArray(array);

    }
}
