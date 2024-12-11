package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0216CombinationSum3 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1);
        return ans;
    }

    public void combinationSum3(int k, int n, int start) {
        if (path.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝
        for (int i = start; i <= 9 && n >= i; i++) {
            path.add(i);
            combinationSum3(k, n - i, i + 1);
            path.removeLast();
        }
    }
}
