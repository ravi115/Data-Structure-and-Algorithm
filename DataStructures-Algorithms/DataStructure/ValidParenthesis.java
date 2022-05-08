import java.util.Stack;

public class ValidParenthesis {

    private static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println("is valid parenthesis :: " + solution.isValid("]"));
    }
}
