package leetcode.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 *
 * @author tengxq
 */
public class LeetCode0131Partition {

    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();


    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }
}
