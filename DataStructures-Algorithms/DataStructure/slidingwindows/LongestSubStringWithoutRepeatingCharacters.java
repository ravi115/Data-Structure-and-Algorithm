package slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = 0;
            int start = 0;
            Set<Character> set = new HashSet<>();
            for (int end = 0; end < s.length(); end++) {
                while (set.contains(new Character(s.charAt(end)))) {
                    set.remove(new Character(s.charAt(start)));
                    start++;
                }
                set.add(new Character(s.charAt(end)));
                len = Math.max(len, end - start + 1);
            }
            return len;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println("====>> length of longest sub string:: " + solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("====>> length of longest sub string:: " + solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println("====>> length of longest sub string:: " + solution.lengthOfLongestSubstring("pwwkew"));
    }
}
