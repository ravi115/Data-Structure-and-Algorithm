package slidingwindows;

public class StockBuySell {

    private static class Solution {
        public int maxProfit(int[] prices) {
            int buyIndex = 0;
            int sellIndex = 1;
            int maxProfit = 0;
            for (; sellIndex < prices.length; sellIndex++) {
                if (prices[buyIndex] < prices[sellIndex]) {
                    maxProfit = Math.max((prices[sellIndex] - prices[buyIndex]), maxProfit);
                } else {
                    buyIndex = sellIndex;
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("=====>> Best Time to Buy and Sell Stock :: " + solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
