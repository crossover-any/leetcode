package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0518Change {

    public static void main(String[] args) {
        LeetCode0518Change leetCode0518Change = new LeetCode0518Change();
        leetCode0518Change.change(5, new int[]{1,2,5});
    }

    public int change(int amount, int[] coins) {
        // dp[i]表示i个硬币凑成金额为j最多有多少种方式
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 遍历物品
        for (int i = 0; i < coins.length; i++) {
            // 遍历容量
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
