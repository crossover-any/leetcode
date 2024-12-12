package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原IP地址
 *
 * @author tengxq
 */
public class LeetCode0093RestoreIpAddress {

    private List<String> result = new ArrayList<>();

    private LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (path.size() > 4) {
            return;
        }
        if (startIndex == s.length() && path.size() == 4) {
            result.add(path.stream().collect(Collectors.joining(".")));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 1.剩下的字符长度不能超过 剩下的ip段*3 2.剩余的字符长度大于 剩下的ip段
            if (s.length() - i > (4 - path.size()) * 3 && s.length() - i >= path.size()) {
                break;
            }
            // 不能以以0开头
            if (s.charAt(startIndex) == '0' && i != startIndex) {
                break;
            }
            // 每一段Num值最大值不能超过255
            int num = Integer.parseInt(s.substring(startIndex, i + 1));
            if (num > 255) {
                break;
            }
            path.add(s.substring(startIndex, i + 1));
            backtracking(s, i + 1);
            path.removeLast();
        }
    }
}
