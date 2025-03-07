package leetcode.order;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2597BeautifulSubsets {

    private int ans = 0;
    // 为什么要用map,因为可能存在重复的数字
    private Map<Integer, Integer> cnt = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, k, 0);
        return ans - 1;
    }

    public void dfs(int[] nums, int k, int i) {
        if (i == nums.length) {
            ans++;
            return;
        }
        // 不选择当前元素
        dfs(nums, k, i + 1);
        // 如果符合要求则选择当前元素
        if (cnt.getOrDefault(nums[i] - k, 0) == 0 && cnt.getOrDefault(nums[i] + k, 0) == 0) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            dfs(nums, k, i + 1);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) - 1);
        }
    }


}
