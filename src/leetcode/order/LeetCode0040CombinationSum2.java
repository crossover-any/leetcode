package leetcode.order;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0040CombinationSum2 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 剩下的不满足 target 的情况，直接退出
            if (target - candidates[i] < 0) {
                break;
            }
            // 每个数字只能使用一次, 这里也可以直接使用path.contains来判断
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
