package leetcode.order;

import java.util.Arrays;

/**
 * 给你一个 二进制 字符串 s 和一个整数 k。
 *
 * 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
 *
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 *
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的
 * 子字符串
 *  的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "0001111", k = 2, queries = [[0,6]]
 *
 * 输出：[26]
 *
 * 解释：
 *
 * 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "0001111" 外，其余子字符串都满足 k 约束。
 *
 * 示例 2：
 *
 * 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]]
 *
 * 输出：[15,9,3]
 *
 * 解释：
 *
 * s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。
 *
 * @author tengxq
 */
public class LeetCode3261CountKConstraintSubstringsII {

    public static void main(String[] args) {
        LeetCode3261CountKConstraintSubstringsII test = new LeetCode3261CountKConstraintSubstringsII();
        long[] result = test.countKConstraintSubstrings("001110001", 3, new int[][]{{1, 8}});
        System.out.println(Arrays.toString(result));
    }

    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        return countKConstraintSubstrings4(s, k, queries);
    }

    public long[] countKConstraintSubstrings4(String S, int k, int[][] queries) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] left = new int[n];
        long[] sum = new long[n + 1];
        int[] cnt = new int[2];
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt[s[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[l++] & 1]--;
            }
            left[i] = l;
            sum[i + 1] = sum[i] + i - l + 1;
        }

        int[] right = new int[n];
        l = 0;
        for (int i = 0; i < n; i++) {
            while (l < n && left[l] < i) {
                l++;
            }
            right[i] = l;
        }

        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ql = queries[i][0];
            int qr = queries[i][1];
            int j = Math.min(right[ql], qr + 1);
            ans[i] = sum[qr + 1] - sum[j] + (long) (j - ql + 1) * (j - ql) / 2;
        }
        return ans;
    }

}
