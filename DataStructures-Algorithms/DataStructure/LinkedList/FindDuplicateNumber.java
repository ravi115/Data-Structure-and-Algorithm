package LinkedList;

public class FindDuplicateNumber {

    private static class Solution {

        /**
         * Based on floyd's cycle detection algorithm.
         *
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {

            int slowIndex = 0;
            int fastIndex = 0;

            // detect cycle using fast and slow pointer.
            while (true) {
                slowIndex = nums[slowIndex];
                fastIndex = nums[nums[fastIndex]];
                if (slowIndex == fastIndex) break;
            }

            // initialize the new slow pointer at beginning and iterate through one step as once
            // and the position where both the new and slow pointer meets return the index of old slow pointer
            int slowIndex2 = 0;
            while (true) {
                slowIndex = nums[slowIndex];
                slowIndex2 = nums[slowIndex2];
                if (slowIndex == slowIndex2) return slowIndex;
            }
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println("Duplicate number is :: " + solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
