package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0017LetterCombinations {

    public static void main(String[] args) {
        LeetCode0017LetterCombinations test = new LeetCode0017LetterCombinations();
        System.out.println(test.letterCombinations("23"));
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack(digits, 0);
        }
        return ans;
    }

    public void backtrack(String digits, int start) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            for (char c : KEYS[digits.charAt(i) - '0'].toCharArray()) {
                path.append(c);
                backtrack(digits, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
