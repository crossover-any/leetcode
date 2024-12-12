package leetcode.order;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0090SubsetsWithDup {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, 0);
        return result;
    }
    public void backtrace(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
        }
    }
}
