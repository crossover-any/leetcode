package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0188MaxProfit {

    public static void main(String[] args) {
        LeetCode0188MaxProfit maxProfit = new LeetCode0188MaxProfit();
        System.out.println(maxProfit.maxProfit(1, new int[]{1}));
    }
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 2K 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出 ... 2k-1: 第k次买入 2k : 第k次卖出
         */
        int[][] dp = new int[len][2*k+1];
        for (int i = 1; i <= k; i++) {
            dp[0][2*i-1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            // 第一次买入的最大收益: 当前买入或沿用前一天的第一次买入状态的最大值
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

            // 第1 2 3 4... K次卖出的最大收益: 当前卖出或沿用前一天的第i次卖出状态的最大值
            // 对应的下标是 2 4 6 8... 2K
            for (int j = 2; j <=2*k; j+=2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
            }

            // 第2 3 4... k次买入的最大收益: 当前买入或沿用前一天的第k次买入状态的最大值
            // 对应的下标是 3 5 7 9... 2K-1
            for (int j = 3; j < 2*k; j+=2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
            }
        }
        return dp[len - 1][2*k];
    }
}
