package sorting;

import java.util.Arrays;

public class CountingSort {

    private static int[] countSort(int[] arr, int min, int max) {

        // calculate range
        int range = max - min;

        // declare frequency array
        int[] freq = new int[range + 1];

        // initialize the frequency
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            freq[index]++;
        }

        //update the frequency for final index position of element
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i - 1] + freq[i];
        }

        // create an answer array of original size length
        int[] ans = new int[arr.length];

        // iterate in reverse order in the original array and update the ans array
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - min;
            int idx = freq[index];
            ans[idx-1] = arr[i];
            freq[index]--;
        }
        // copy the ans array into original array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8, 200, 67, 23, 67, 2, 2000, 1, 35, 2, 200, 1, 35, 8, 2000};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println("Array before sorting :: " + Arrays.toString(arr));

        System.out.println("Array after sorting:: " + Arrays.toString(countSort(arr, min, max)));

    }
}
