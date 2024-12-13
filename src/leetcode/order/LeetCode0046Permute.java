package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0046Permute {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] visited = null;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrace(nums);
        return result;
    }

    public void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.removeLast();
            visited[i] = false;
        }
    }
}
