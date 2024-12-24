package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0279NumSquares {

    public static void main(String[] args) {
        System.out.println(new LeetCode0279NumSquares().numSquares(1));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n ; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
