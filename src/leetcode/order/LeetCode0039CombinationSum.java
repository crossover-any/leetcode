package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0039CombinationSum {

    public static void main(String[] args) {
        LeetCode0039CombinationSum combinationSum = new LeetCode0039CombinationSum();
        int[] candidates = {8,7,4,3};
        int target = 11;
        List<List<Integer>> ans = combinationSum.combinationSum(candidates, target);
        System.out.println(ans);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start) {
        if (start == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 选择当前数
        if (target >= candidates[start]) {
            path.add(candidates[start]);
            backtrack(candidates, target - candidates[start], start);
            path.removeLast();
        }
        // 跳过
        backtrack(candidates, target, start + 1);

    }
}
