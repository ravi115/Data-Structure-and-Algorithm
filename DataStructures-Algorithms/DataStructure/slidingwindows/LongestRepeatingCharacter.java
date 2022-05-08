package slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 424
 */
public class LongestRepeatingCharacter {

    private static class Solution {
        public int characterReplacement(String s, int k) {
            int start = 0;
            int len = 0;
            int maxF = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0; end < s.length(); end++) {
                Character character = new Character(s.charAt(end));
                if (map.containsKey(character)) {
                    map.put(character, 1 + map.get(character));
                } else {
                    map.put(character, 1);
                }
                while ((end - start + 1) - map.values().stream().reduce(0, Integer::max) > k) {
                    Character temp = new Character(s.charAt(start));
                    map.put(temp, 1 - map.get(temp));
                    start++;
                }
                len = Math.max(end - start + 1, len);
            }
            return len;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Length of Longest Repeating character :: " + solution.characterReplacement("AABABBA", 1)); // o/p: AABBBBA => 4
        System.out.println("Length of Longest Repeating character :: " + solution.characterReplacement("ABAB", 2)); // o/p: AABBBBA => 4
        System.out.println("Length of Longest Repeating character :: " + solution.characterReplacement("AAAA", 0)); // o/p: AABBBBA => 4
    }
}
