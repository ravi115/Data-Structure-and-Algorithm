package mathematics;

public class LCMandGCD {
	
	/*
	 * Find GCD of two numbers 
	 * 
	 */
	
	private static int findGCD(int n1, int n2 ) {
		
		int nGCD = 0;
		for(int i = 1 ; i <= n1 && i <= n2; i++ ) {
			if(n1 % 1 ==0 && n2 % i == 0 ) {
				nGCD = i;
			}
		}
		return nGCD;
	}
	

	/*
	 * Finds the LCM of two number. 
	 * 
	 */
	private static int findLCM(final int n1, final int n2) {
		
		int nLeastCommonFactor = (n1 > n2) ? n1 : n2;
		
		while(true) {
			
			if(nLeastCommonFactor%n1 == 0 && nLeastCommonFactor%n2 == 0) {
				
				break;
			}
			++nLeastCommonFactor;
		}
		
		return nLeastCommonFactor;
	}
	
	public static void main(String[] args) {
		
		System.out.println("The LCM of 72 and 120 is " 	+ findLCM(72, 120));
		System.out.println("The LCM of 15 and 25 is " 	+ findLCM(15, 25));
		System.out.println("The LCM of 20 and 80 is " 	+ findLCM(20, 80));
		
		System.out.println("\n\n------- *** -----------");
		System.out.println("The GCD of 3 and 5 is " + findGCD(3, 5));
		System.out.println("The GCD of 2 and 4 is " + findGCD(2, 4));

	}

}
