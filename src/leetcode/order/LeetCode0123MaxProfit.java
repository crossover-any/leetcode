package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0123MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 第一次买入或者沿用前一天的第一次买入状态
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            // 第一次卖出：前一天没有操作或者当前卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第二次买入：前一天没有操作或者当前买入
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 第二次卖出：前一天没有操作或者当前卖出
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}
