package arrays;

import java.util.*;

public class TopKFrequent {

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            int[] ans = new int[k];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<List<Integer>> list = new ArrayList<>(nums.length);

            TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder());

            for (Map.Entry<Integer, Integer> objEntry : map.entrySet()) {
                if (treeMap.containsKey(objEntry.getValue())) {
                    treeMap.get(objEntry.getValue()).add(objEntry.getKey());
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(objEntry.getKey());
                    treeMap.put(objEntry.getValue(), temp);
                }
            }

            int index = 0;
            for (Map.Entry<Integer, List<Integer>> objEntry : treeMap.entrySet()) {
                for (int n : objEntry.getValue()) {
                    if (index < k) {
                        ans[index++] = n;
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{3, 1, 0, 1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 2}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 0}, 2)));

    }
}
