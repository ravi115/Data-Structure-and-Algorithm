package arrays;

public class ContainerWithMostWater {

    private static class Solution {

        private int BFApproach(int[] height) {
            int maxArea = Integer.MIN_VALUE;

            for (int i = 0; i < height.length; i++) {
                for (int j = 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }

        public int maxArea(int[] height) {
            return BFApproach(height);
        }

        public int maxAreaOptimized(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                if (height[left] < height[right]) {
                    left++;
                }else {
                    right--;
                }
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("====> max area:: " + solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("====> max area:: " + solution.maxAreaOptimized(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
