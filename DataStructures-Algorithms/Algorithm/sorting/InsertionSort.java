package Sorting;

/**
 * This class implements the insertion sort algorithm.
 * @author raviranjan
 *
 */

/*
	12, 11, 13, 5, 6
	
	Let us loop for i = 1 (second element of the array) to 5 (Size of input array)
	
	i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
	11, 12, 13, 5, 6
	
	i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
	11, 12, 13, 5, 6
	
	i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
	5, 11, 12, 13, 6
	
	i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
	5, 6, 11, 12, 13 

*/
public class InsertionSort {

	/* insertion sort.
	 * 
	 */
	private static void insertionSort(int[] a) {
		
		//length of the array
		int n = a.length;
		
		for(int i = 1; i < n ; i++ ) {
			
			//second element
			int key = a[i];
			
			//previous index of second element
			int j = i-1;
			
			/* iterates and replace until 
			 * the previous element is larger 
			 * than current element pointed by i th index.
			 */
			
			 /* Move elements of arr[0..i-1], that are
	          * greater than key, to one position ahead
	          * of their current position 
	          */
			while(j >= 0 && a[j] > key) {
				
				a[j+1] = a[j];
				j = j-1;
			}
			//put the key element
			a[j+1] = key;
		}
		
		//sorted element
		System.out.println("sorted element..........");
		for(int a1 : a ) {
			System.out.print(a1 + " ");
		}
	}
	public static void main(String[] args) {

		final int[] a = {9, 1, 5, 4, 2, 3};
		insertionSort(a);
	}

}
