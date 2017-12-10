package mathematics;

/**
 * This class illustrate the prime number logic.
 * 
 * @author raviranjan
 *
 */

/*
 * prime number is a whole number which is greater than 1 and completely divisible by itself or 1. 
 * 
 */
public class PrimeNumber {


	/*
	 * 1 is not prime.
	 * 2,3 is the first consecutive prime number. 
	 * so loop will start with 2. because less than 2 will not be the prime number.
	 * we will divide the given number to all the number starts with 2 till the half of the given number.   
	 * 
	 */
	private static boolean primeNumber(int n) {

		boolean bIsPrime = true;
		if(n < 2)
			return false;
		for(int i = 2 ; i <= n/2; i++ ) {

			int temp = n%i;
			if(temp == 0)
			{
				bIsPrime = false;
				break;
			}
		}
		return bIsPrime;
	}

	public static void main(String[] args) {

		System.out.println("is 2 prime ? " 	+ 	((primeNumber(2) == true) ? "yes" : "no"));
		System.out.println("is 7 prime ? " 	+ 	((primeNumber(7) == true) ? "yes" : "no"));
		System.out.println("is 11 prime ? " + 	((primeNumber(11) == true) ? "yes" : "no"));
		System.out.println("is 6 prime ? " 	+ 	((primeNumber(6) == true) ? "yes" : "no"));
		System.out.println("is 25 prime ? " 	+ 	((primeNumber(6) == true) ? "yes" : "no"));
		System.out.println("is 9 prime ? " 	+ 	((primeNumber(6) == true) ? "yes" : "no"));
		System.out.println("is 15 prime ? " 	+ 	((primeNumber(6) == true) ? "yes" : "no"));
		
		System.out.println("------ **** -----------");
		System.out.println("\nLet's find all the prime number between 1..100");
		for(int i =1; i <=100; i++ ) {
			
			if(primeNumber(i))
					System.out.println(i + " is the prime number!");
			else
				System.out.println(i + " is not a prime number!");
		}
	}
}
