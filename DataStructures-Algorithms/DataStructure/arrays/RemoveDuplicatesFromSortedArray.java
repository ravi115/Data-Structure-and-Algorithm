package arrays;

public class RemoveDuplicatesFromSortedArray {

    static void shift(int[] arr, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[end - 1] = 0;
    }

    static int removeDuplicates(int[] nums) {

        int prev = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                shift(nums, i, nums.length);
            } else {
                k++;
            }
            prev = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);

        for (int i = 0; i < k; i++) {
            System.out.println("::" + nums[i]);
        }
    }
}
