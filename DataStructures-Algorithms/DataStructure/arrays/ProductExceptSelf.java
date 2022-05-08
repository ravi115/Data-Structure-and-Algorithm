package arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {

            int prefix = 1;
            int postfix = 1;

            int[] output = new int[nums.length];

            // calculate prefix into output array going from left to right
            for (int i = 0; i < nums.length; i++) {
                output[i] = prefix;
                prefix *= nums[i];
            }

            // calculate postfix into output array from right to left which will give us final result
            for (int i = nums.length - 1; i >= 0; i--) {
                output[i] *= postfix;
                postfix *= nums[i];
            }

            return output;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
