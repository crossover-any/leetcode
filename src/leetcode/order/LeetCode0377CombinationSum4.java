package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0377CombinationSum4 {

    public static void main(String[] args) {
        new LeetCode0377CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 5);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
