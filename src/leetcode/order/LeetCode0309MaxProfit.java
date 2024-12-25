package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0309MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int i = new LeetCode0309MaxProfit().maxProfit(prices);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 3 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 冷冻期
         */
        int[][] dp = new int[len][4];
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 买入: 1.上次买入状态 2.当前买入,不过是需要加上冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][3]- prices[i]);
            // 卖出：1.上次卖出状态 2.当前卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 冷冻期：1.上次冷冻期状态 2.上一次卖出状态
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        }

        return Math.max(dp[len - 1][2], dp[len - 1][3]);
    }
}
