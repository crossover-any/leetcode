package leetcode.order;

/**
 *
 * 给你一个 m x n 的二进制矩阵 grid 。
 *
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 *
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 *
 * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
 * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/">题目链接</a>
 * @author tengxq
 */
public class LeetCode3239MinFlips {

    public int minFlips(int[][] grid) {
        int rowCnt = 0, colCnt = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j1 = 0, j2 = n - 1; j1 < j2; j1++, j2--) {
                if ((grid[i][j1] ^ grid[i][j2]) != 0) {
                    rowCnt++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i1 = 0, i2 = m - 1; i1 < i2; i1++, i2--) {
                if ((grid[i1][j] ^ grid[i2][j]) != 0) {
                    colCnt++;
                }
            }
        }
        return Math.min(colCnt, rowCnt);
    }
}
