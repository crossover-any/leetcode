package leetcode.order;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode0494FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {

        return 0;
    }


    int result = 0;

    /**
     * 回溯法
     *
     * @param nums
     * @param target
     * @param start
     */
    public void backtrace(int[] nums, int target, int start) {
        if (target == 0 && start == nums.length) {
            result++;
        }
        if (start == nums.length) {
            return;
        }
        backtrace(nums, target - nums[start], start + 1);
        backtrace(nums, target + nums[start], start + 1);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @param target
     * @return
     */
    public int dp(int[] nums, int target) {
        // 总和sum >=0 正数和x  负数和sum-x
        int sum = Arrays.stream(nums).sum();
        //如果target的绝对值大于sum，那么是没有方案的
        if (Math.abs(target) > sum) {
            return 0;
        }
        //如果(target+sum)除以2的余数不为0，也是没有方案的
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
