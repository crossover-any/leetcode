package leetcode.order;

import java.util.Arrays;

public class LeetCode1278PalindromePartition {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        // 定义动态数组，cost[i][j] 表示 i~j坐标的字符串变成回文字符串替换需要的最小次数
        int[][] f = new int[n + 1][k + 1];
        for (int[] row : f) {
            // 设置一个最大值
            Arrays.fill(row, 1000000000);
        }
        // 这里也可不初始化，因为当j=1时不会去比较j-1的情况，直接统计的是整个字符串
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(k, i); j++) {
                if (j == 1) {
                    // 分成一段的话，直接计算0-i-1的数量
                    f[i][j] = cost(0, i - 1, s);
                } else {
                    // 分成j段，
                    for (int i0 = j - 1; i0 < i; i0++) {
                        // 枚举从 以i0~i-1为起始位置的回文字符串最小值
                        // 加上 i0前分割成了 j - 1段位置的最小值 刚好是 j段
                        f[i][j] = Math.min(f[i][j], f[i0][j - 1] + cost(i0, i - 1, s));
                    }
                }
            }
        }

        return f[n][k];
    }

    private int cost(int l, int r, String s) {
        int ret = 0;
        int i = l, j = r;
        while (i < j) {
            ret += (s.charAt(i) == s.charAt(j) ? 0 : 1);
            i++;
            j--;
        }
        return ret;
    }

}
