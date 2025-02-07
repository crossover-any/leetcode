package leetcode.order;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class LeetCode0032LongestValidParentheses {

    public static void main(String[] args) {
        LeetCode0032LongestValidParentheses solution = new LeetCode0032LongestValidParentheses();
        System.out.print(solution.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}
