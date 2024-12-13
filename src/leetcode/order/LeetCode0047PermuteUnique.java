package leetcode.order;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 *
 * @author tengxq
 */
public class LeetCode0047PermuteUnique {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] visited = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        backtrace(nums);
        return result;
    }

    public void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 控制本层遍历的元素，避免重复
        Set<Integer> dict = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || dict.contains(nums[i])) {
                continue;
            }
            dict.add(nums[i]);
            visited[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.removeLast();
            visited[i] = false;
        }
    }
}
