package Sorting;

/**
 * This class provides the solution for selection sort algorithm.
 * @author raviranjan
 *
 */

/*
 * 
	arr[] = 64 25 12 22 11

	This algorithm works with swapping the least element which found during comparing with current 
	element. 
	
	step -1 : we divide the array into two parts one is sorted and another is unsorted.
	step -2 : we pick up the first element from the array and start comparing with other element
	 		  if we found any element smaller than this then we will replace this element with the
	 		  current element and continue the same process till end. and then replace the first element
	 		  with this element.  
	
	Find the minimum element in arr[0...4]
	and place it at beginning
	11 25 12 22 64

	Find the minimum element in arr[1...4]
	and place it at beginning of arr[1...4]
	11 12 25 22 64

	Find the minimum element in arr[2...4]
	and place it at beginning of arr[2...4]
	11 12 22 25 64

	Find the minimum element in arr[3...4]
	and place it at beginning of arr[3...4]
	11 12 22 25 64 

 */

/*
 * Time complexity : O(n^2) -- > worst | best
 * space complexity : O(n) 
 * 
 */
public class SelectionSort {


	private static void selectionSort(int[] a) {

		//length of the array
		int n = a.length;

		//outer for-loop to increment the counter till last element in the array
		for(int i = 0 ; i < n ; i++ ) {

			//Expected minimum element which has to be placed in the sorted part of array.
			int min_element_index = i;

			//inner for-loop to find the list element from (i, n); 
			for(int j = i+1 ; j < n; j++ ) {

				if(a[min_element_index] > a[j]) 
					//set the min_element_index to j.
					min_element_index = j;
			}

			/*
			 * swap the element at jth (min) with ith (max). 
			 */

			int temp = a[i];
			//replace the max value at ith index with minumum_element_index value.
			a[i] = a[min_element_index];
			//store back the ith value to minimum index position.
			a[min_element_index] = temp;
		}

		///element is sorted .
		System.out.println("Sorted array .....");
		for(int a1 : a ) {
			System.out.print(a1 + " ");
		}
	}

	public static void main(String[] args) {

		final int[] a = {9, 17, 1, 22, 89, 65, 32};
		selectionSort(a);
	}

}
