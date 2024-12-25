package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0213Rob {

    public static void main(String[] args) {
        LeetCode0213Rob leetCode0213Rob = new LeetCode0213Rob();
        System.out.println(leetCode0213Rob.rob(new int[]{0}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[i] = nums[i];
            } else if (i == start + 1) {
                dp[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[end];
    }
}
