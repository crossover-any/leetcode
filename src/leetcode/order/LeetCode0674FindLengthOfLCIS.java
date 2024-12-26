package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0674FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
               count = 1;
            }
        }
        return maxCount;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxCount = Math.max(maxCount, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return maxCount;
    }
}
