package leetcode.order;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0491FindSubsequences {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrace(nums, 0);
        return result;
    }

    public void backtrace(int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 去除重复的
            if (set.contains(nums[i])) {
                continue;
            }
            // 去除 非递增的
            if (path.size() > 0 && nums[i] < path.getLast()) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
        }
    }
}
