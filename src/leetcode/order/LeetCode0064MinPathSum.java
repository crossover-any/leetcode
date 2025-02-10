package leetcode.order;

import java.util.Arrays;

public class LeetCode0064MinPathSum {

    public static void main(String[] args) {
        LeetCode0064MinPathSum leetCode0064MinPathSum = new LeetCode0064MinPathSum();
        leetCode0064MinPathSum.minPathSum(new int[][]{{1,2,3}, {4,5,6}});
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, dp[i + 1], 1, n);
            if (i > 0) {
                dp[i + 1][0] = 1000;
            }
        }
        Arrays.fill(dp[0], 1, n + 1,  1000);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i][j];
            }
        }
        return dp[m][n];

    }
}
