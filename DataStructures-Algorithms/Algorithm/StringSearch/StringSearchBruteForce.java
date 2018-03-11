package StringSearch;

public class StringSearchBruteForce {


	private static void stringSearch(final String text, final String pattern ) {

		for(int i = 0; i < text.length(); i++ ) {

			for(int j = 0 ; j < pattern.length() && i + j < text.length(); j++ ) {

				if(text.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
				if(i == j) {
					System.out.println("token found in the pattern at index : " + i);
				}
				
			}
		}




		/*int j = 0;
			while(j < pattern.length() && pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;

			}
			if(j == pattern.length() ) {
				System.out.println("token found in the pattern at index : " + (i-j));
			}
		}
		 */

	}
	public static void main(String[] args) {

		//pattern set 1
		final String text = "AABA AAA CCBA ASDF CCBA FHGJT CCBA";
		final String pattern = "CCBA";

		System.out.println("Pattern set -1 ");
		stringSearch(text, pattern);

		System.out.println("==============================");

		//pattern set 2
		final String pattern2 = "AABAACAADAABAABA";
		final String token2 = "AABA";

		System.out.println("pattern set -2");
		stringSearch(pattern2, token2);

		System.out.println("============================");
	}

}
