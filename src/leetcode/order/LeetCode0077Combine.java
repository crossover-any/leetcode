package leetcode.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0077Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    public void combine(int n, int k, int start, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 简单的是i<=n,增加剪枝操作,减少无意义的递归 n - (k - path.size())+ 1最大开始的位置，再大的话就不够数了
        // 为什么要+1?例如 5-3=2, 如果K=2的话，其实最大的开始位置是下标3, 组成(3,4)
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combine(n, k, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
