package Search;

public class BinarySearch {


	private static Integer search(final int[] a, int key ) {

		Integer index = null;

		//lenth of array
		int n = a.length;

		/*
		 * compare key with the middle of the element of array.
		 * 
		 */

		//means element can be found after the middle to right part of the array.
		if(key >= a[n/2]) {

			for(int i = n/2; i < n; i++ ) {

				if(a[i] == key) {
					index = i;
					break;
				}

			}
		}
		//element can be found before middle to the left part of the array.
		else {

			for(int i = 0; i < n/2; i++ ) {
				
				if(a[i] == key) {
					index = i;
					break;
				}
			}
		}

		return index;
	}

	public static void main(String[] args) {

		//sorted array
		int[] a = {9, 10, 11, 15, 25, 30};

		//check whether this element is available in the above array or not.
		int key = 9;

		System.out.println("The element is found at index : " + search(a, key));

	}
}
