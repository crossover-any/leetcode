package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode1049LastStoneWeight {

    /**
     * 1049. 最后一块石头的重量 II
     * <p>
     *     这里其实是01背包问题，只不过是求最小值，所以只需要求出sum/2向下取整，然后遍历背包，求出sum-dp[target] - dp[target]即可
     *     思想是尽可能将石头分成重量均匀的两堆，但实际情况可能不够均分，所以求sum/2能够容纳最大的重量的石头，那么就可以得到最小重量
     * </p>
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        // 将石头分为两堆 dp[target] 与 sum - dp[target], 那么剩余最小重量就等于 sum-dp[target] - dp[target]
        // 因为 target = sum / 2向下取整, 那么sum - dp[target] > dp[target]
        return sum - 2 * dp[target];
    }
}
