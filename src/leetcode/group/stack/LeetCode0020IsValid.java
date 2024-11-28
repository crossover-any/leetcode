package leetcode.group.stack;

import java.util.*;

/**
 *
 *
 * @author tengxq
 */
public class LeetCode0020IsValid {

    private Map<Character, Character> dict = new HashMap<>();

    {
        dict.put('(', ')');
        dict.put('[', ']');
        dict.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (dict.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (dict.get(top) != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
