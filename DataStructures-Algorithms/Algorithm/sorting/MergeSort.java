package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author raviranjan
 *
 */
public class MergeSort {

	/**
	 * Algorithms: - 
	 * 
	 * if array size < 2 {
	 * 		return array;
	 * }
	 * else {
	 * 		sort left subArray(array, low, mid)
	 * 		sort right subArray(array, mid+1, high)
	 * 		combine them
	 * }
	 * 
	 * @param args
	 */
	private static int[] mergerSort(int[] array) {

		int[] left ;
		int[] right;

		int high = array.length;
		int low = 0;

		//if there is only one element no need to divide further.


		//find a middle point to assign first half to left and second half to right.
		int mid = (low + high);

		if(mid % 2 == 0) {
			left = new int[mid/2];
			right = new int[mid/2];
		}else {
			left = new int[mid/2];
			right = new int[mid/2 + 1];
		}

		//fill up left and right sub array
		for(int i = 0; i <high; i++) {
			if(i < mid/2) {
				left[i] = array[i];
			}else {
				right[i-mid/2] = array[i];
			}
		}
		//recursively split both the left as well as right array. [called divide process]
		if(low < high) {
			if(null != left)
				left = mergerSort(left);

			if(null != right)
				right = mergerSort(right);

		}
		//call merge to merge each divided array in sorted array.
		return merge(left, right);
	}

	/**
	 * 
	 * step 1: create a fresh memory to hold the combined array.
	 * step 2: start comparing left and right array element and them in new memory in ascending order.
	 * step 3: copy all left sub array into new memory.
	 * step 4: copy all right sub array into new memory. 
	 * 
	 * @param left ->  left sub array
	 * @param right -> right sub array
	 * @return sorted array after joining left and right.
	 */
	private static int[] merge(int[] left, int[] right) {

		//memory to merge the array
		int[] result = new int[left.length + right.length];

		//running indices
		int i = 0;
		int j = 0;
		int index = 0;

		//compare left and right array element and add to result array based on asscending order.
		while(i < left.length && j < right.length) {

			if(left[i] < right[j]) {
				result[index++] = left[i++];
			}else {
				result[index++] = right[j++];
			}
		}
		//add all left  sub array

		while(i < left.length)
			result[index++] = left[i++];

		//add all right sub array
		while(j < right.length)
			result[index++] = right[j++];

		return result;
	}


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Length of Array : ");

		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Enter space separated elements");

		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Entered array : " + Arrays.toString(array) );
		scan.close();

		int[] result = mergerSort(array);

		System.out.println("........... Arrays are sorted ...............");
		System.out.println(Arrays.toString(result));
	}

}
