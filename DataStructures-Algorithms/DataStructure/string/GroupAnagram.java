package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    private static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                char[] count = new char[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    count[strs[i].charAt(j) - 'a']++;
                }
                String key = "";
                for (int k = 0; k < count.length; k++) {
                    key += count[k];
                }

                if (map.containsKey(key)) {
                    map.get(key).add(strs[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    map.put(key, list);
                }
            }
            List<List<String>> result = new ArrayList<>(map.values());
            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}
