package leetcode.group.dp;

/**
 * @author tengxq
 */
public class bag01 {

    /**
     * 二维数组
     *
     * @param weight
     * @param value
     * @param bagWeight
     * @return
     */
    public int bag01_1(int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[weight.length + 1][bagWeight + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 放入当前物品还是不放入
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[weight.length][bagWeight];
    }

    public int bag01_2(int[] weight, int[] value, int bagWeight) {
        // 压缩成一维数组, 但是遍历顺序不同,如果从小到大遍历的话,会出现重复计算
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            // 倒序遍历:保证物品只被放入一次
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }
}
