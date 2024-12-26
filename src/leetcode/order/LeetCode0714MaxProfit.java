package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0714MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 卖出股票获得收益
                profit += prices[i] - buy;
                // 这里设置买入价格为当天价格，1.如果后面有更高的价格，可以再次买入，并且不会再次收取手续费。
                buy = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices, int fee) {
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
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 第i天持有股票的最大收益=前一天持有股票的最大收益dp[i-1][1]和当天买入的最大收益中的较大值 dp[i-1][0] - prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] - prices[i]);
        }
        // 最后一天不持有股票的最大收益
        return dp[length - 1][0];
    }
}
