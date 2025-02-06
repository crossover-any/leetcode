package leetcode.order;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0797AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> res) {
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(path));
        }
        int[] arr = graph[cur];
        for (int j : arr) {
            path.add(j);
            dfs(graph, j, path, res);
            path.remove(path.size() - 1);
        }
    }
}
