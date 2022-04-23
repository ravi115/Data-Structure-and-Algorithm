package sorting;

import java.util.Arrays;

public class RadixSort {

    private static int[] countingSort(int[] arr, int exp) {

        // create an 0-9 range of frequency array
        int[] freq = new int[10];

        // initialize the frequency count based on the one's occurrence of number
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] / exp) % 10; // to get the first number in the digit. let's say 159 -> gives us 9
            freq[index]++;
        }

        //update the index position by adding with prev value.
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        //create an answer array of original length
        int[] ans = new int[arr.length];

        // update the ans array from frequency array
        for (int i = arr.length - 1; i > 0; i--) {
            int index = (arr[i] / exp) % 10;
            int idx = freq[index];
            ans[idx - 1] = arr[i];
            freq[index]--;
        }
        // copy the array into answer
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }

        return arr;
    }

    private static int[] radixSort(int[] arr) {

        // first find the maximum number from the array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // sorting has to be done from one's number towards hundredth, thousandth...so on
        for (int exp = 1; max / exp > 0; exp *= 10) {
            arr = countingSort(arr, exp);
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] arr = {90, 2, 45, 32, 12, 2000, 12, 32, 45, 1, 0, 9, 2000};
        System.out.println("Array before sorting:: " + Arrays.toString(arr));

        arr = radixSort(arr);
        System.out.println("Array after sorting :: " + Arrays.toString(arr));
    }
}
