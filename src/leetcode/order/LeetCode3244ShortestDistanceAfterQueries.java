package leetcode.order;

import datatruct.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode3244ShortestDistanceAfterQueries {

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2, 4},{1, 4}};
        int[] res = new LeetCode3244ShortestDistanceAfterQueries().shortestDistanceAfterQueries2(n, queries);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> prev = new ArrayList<>(n);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (i > 0) {
                list.add(i -1);
            }
            dp[i] = i;
            prev.add(list);
        }
        for (int i = 0; i < queries.length; i++) {
            // 更新prev
            prev.get(queries[i][1]).add(queries[i][0]);
            // 更新dp
            for (int j = queries[i][1]; j < n; j++) {
                for (Integer fromIndex  : prev.get(j)) {
                    dp[j] = Math.min(dp[j], dp[fromIndex] + 1);
                }
            }
            res[i] = dp[n-1];
        }
        return res;
    }

    public int[] shortestDistanceAfterQueries2(int n, int[][] queries) {
        UnionFind uf = new UnionFind(n - 1);
        int[] ans = new int[queries.length];
        int cnt = n - 1; // 并查集连通块个数
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1] - 1;
            int fr = uf.find(r);
            for (int i = uf.find(l); i < r; i = uf.find(i + 1)) {
                uf.parent[i] = fr;
                cnt--;
            }
            ans[qi] = cnt;
        }
        return ans;
    }
}
