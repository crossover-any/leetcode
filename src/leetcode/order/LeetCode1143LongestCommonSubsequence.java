package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j]: text1[0...i-1] 和 text2[0...j-1] 的最长公共子序列长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，则取字符串前一个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
