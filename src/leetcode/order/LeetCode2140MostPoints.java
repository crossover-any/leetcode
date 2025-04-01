package leetcode.order;

import java.util.Arrays;

public class LeetCode2140MostPoints {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // 解决每道题及以后题目的最高分数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }
}
