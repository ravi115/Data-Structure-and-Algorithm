package algorithm;

import java.util.Arrays;

public class QuickSort {

	public static void swap(int[] arr, int index1, int index2) {

		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static int partition(int[] arr, int low, int high) {

		int i = low - 1;
		int j = low;
		int pivot = arr[high];

		for (; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, high);
		return i + 1;

	}

	public static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}

	}

	public static void main(String[] args) {

		int[] arr = { 8, 2, 7, 9, 1, 6, 3, 5, 10 };

		System.out.println("Before sorting ::: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("after sorting :::: " + Arrays.toString(arr));

	}
}
