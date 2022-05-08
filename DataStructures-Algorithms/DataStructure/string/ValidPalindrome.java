package string;

public class ValidPalindrome {

    private static class Solution {

        private boolean isAlphaNumeric(char c) {
            return (c < 48 || c > 57) &&
                    (c < 65 || c > 90) &&
                    (c < 97 || c > 122);
        }

        private boolean isCaseInSensitiveSame(char c1, char c2) {
            int diff = Math.abs(c1 - 65); // 48 - 57
            return c1 == c2 ||
                    c2 == (65 + (diff - 32)) ||
                    c2 == (97 + diff) ||
                    c2 == (65 + diff);
        }

        public boolean isPalindrome(String s) {

            int left = 0;
            int right = s.length() - 1;

            int len = s.length();
            while (left < right) {

                while (left < len && isAlphaNumeric(s.charAt(left))) {
                    left++;
                }

                while (right >= 0 && isAlphaNumeric(s.charAt(right))) {
                    right--;
                }

                if (left < len && right > -1 && !isCaseInSensitiveSame(s.charAt(left), s.charAt(right))) return false;
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(":: =====> \"v' 5:UxU:5 v'\" :: " + solution.isPalindrome("v' 5:UxU:5 v'"));
    }
}
