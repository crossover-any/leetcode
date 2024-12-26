package leetcode.order;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode0300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 以nums[i]结尾的子序列的最大长度
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            // j < i
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 取dp[j] + 1的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
