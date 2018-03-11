package Search;

/**
 *binary Search Algorithm with recursively divide until find the key.
 * @author raviranjan
 *
 */
public class RecursivelyBinarySearch {

	private static boolean binarySearch(int[] array, int low, int high, int key) {
		
		if(low > high ) {
			return false;
		}
		int mid = (low + high)/2;
		
		if(key == array[mid]) {
			System.out.println("Found! : at : " + mid);
			return true;
		}else if(key > array[mid]) {
			return binarySearch(array, mid+1, high, key);
		}else {
			return binarySearch(array, low, mid-1, key);
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {15,22,32,36,40,46,98,101};
		int key = 15;
		boolean b = binarySearch(array,0,array.length, key);
		System.out.println("Key Found (True/False) ? : " + b);
	}
}
