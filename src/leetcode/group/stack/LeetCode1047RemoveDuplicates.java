package leetcode.group.stack;


import java.util.Stack;

/**
 * @author tengxq
 */
public class LeetCode1047RemoveDuplicates {

    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
