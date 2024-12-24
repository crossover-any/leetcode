package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0322CoinChange {

    public static void main(String[] args) {
        LeetCode0322CoinChange coinChange = new LeetCode0322CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 这里的判断条件意义是如果不能组合出来，则跳过，否则就取最小值
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
