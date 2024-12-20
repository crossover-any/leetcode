package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0416CanPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 遍历数字
        for (int i = 0; i < n; i++) {
            // 遍历背包
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }

}
