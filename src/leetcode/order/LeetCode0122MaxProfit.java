package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0122MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[-1];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        // dp[i][0]代表第i天不持有股票的最大收益
        // dp[i][1]代表第i天持有股票的最大收益
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 第i天不持有股票的最大收益=前一天不持有股票的最大收益dp[i-1][0]和当天卖出的最大收益中的较大值dp[i-1][1] + prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有股票的最大收益=前一天持有股票的最大收益dp[i-1][1]和当天买入的最大收益中的较大值 dp[i-1][0] - prices[i]
            // 这里与121的区别是121只能买卖一次，而122可以买卖多次,买一次直接减去prices[i]，而122可以买卖多次，所以这里是dp[i-1][0] - prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] - prices[i]);
        }
        // 最后一天不持有股票的最大收益
        return dp[length - 1][0];
    }
}
