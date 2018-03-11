package Sorting;

/**
 * This class will provide bubble sort solution with variety of approach.
 * @author raviranjan
 *
 */

/*
	First Pass:
	( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
	( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
	( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
	( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

	Second Pass:
	( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
	( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
	Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

	Third Pass:
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 */
public class BubbleSort {

	/* 1. Basic Approach
	 * 
	 * This approach always consumes Space complexity = O(n)
	 * This approach always consumes Time complexity = O(n^2) 
	 * 
	 * even if the array is sorted it will consume same space and same time i.e. mentioned above.
	 * 
	 * best Case (n^2)
	 * worst Case (n^2)
	 */
	private static void sort(int[] a) {

		int length = a.length;
		for(int i = 0 ; i < length; i++ ) {

			for(int j = 1 ; j < length; j++ ) {

				//check previous element in the array is larger than current element.
				if(a[j-1] > a[j]) {

					//swap the element.
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}

		//sorting done.
		//Let's print out the sorted array.
		System.out.println("sorted array is......");
		for(int a1 : a) {
			System.out.print(a1 + " ");
		}
	}

	/* 2. Advanced Approach.
	 * 
	 * In this approach we can perform sorting in O(n) time for sorted array.
	 * best case O(n)
	 * worst Case (n^2)
	 * 
	 */
	private static void optimizedApproach(int[] a) {

		int length = a.length;
		
		//if no swapping is done means array is already sorted.
		//so break the outer loop to repeat this process again.
		boolean bIsSwapped = false;
		
		for(int i = 0 ; i < length; i++ ) {

			for(int j = 1 ; j < length; j++ ) {

				//check previous element in the array is larger than current element.
				if(a[j-1] > a[j]) {

					//swap the element.
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					bIsSwapped = true;
				}
			}
			if(!bIsSwapped)
				break;
		}
		//sorting done.
		//Let's print out the sorted array.
		System.out.println("\nOptimzed sorted array is......");
		for(int a1 : a) {
			System.out.print(a1 + " ");
		}

	}

	public static void main(String[] args) {

		final int[] a = {9, 18, 11, 7, 6, 1 ,21};

		sort(a);

		optimizedApproach(a);
	}

}























