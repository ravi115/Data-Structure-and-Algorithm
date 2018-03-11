package mathematics;

import java.util.LinkedList;
import java.util.Scanner;


public class Test {

	
	static int count(LinkedList<Integer> list, int chocalate) {
		
		int count = 1;
		for(int i = list.size()-2; i>=0; i--) {
			
			if(chocalate < list.get(i)) {
				
				count = (count == 1) ? 1: count;
				break;
			}
			count++;
		}
		
		return count;
		
	}

	static int[][] calculate(int[][] arrays, int n) {

		int[][] result = new int[n][];
		
		
		for(int i = 0; i<n; i++ ) {
			
			result[i] = new int[arrays[i].length];
			
			LinkedList<Integer> list = new LinkedList<>();
			for(int j = 0; j<arrays[i].length; j++) {
				
				list.add(arrays[i][j]);
				if(j != 0) {
					result[i][j] = count(list, arrays[i][j]);
				}else {		
					result[i][j] = 1;	
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n;
		n = scan.nextInt();

		int[][] arrays = new int[n][];

		for(int i=0; i<n; i++) {

			int no_of_days = scan.nextInt();
			
			arrays[i] = new int[no_of_days];
			for(int j=0; j<no_of_days; j++) {

				arrays[i][j] = scan.nextInt();
			}
		}
		int[][] result = calculate(arrays, n);
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j< result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("\n");
		}
		scan.close();
	}

}
