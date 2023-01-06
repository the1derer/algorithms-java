package algorithms;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 25}; // arr is sorted till N - 2 th place
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] <= arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            } else break;
        }

        System.out.println();
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}
