package leetcode.order;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode0935KnightDialer {


    static final int MOD = 1000000007;

    public int knightDialer(int n) {
        int[][] moves = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int[][] d = new int[2][10];
        Arrays.fill(d[1], 1);
        for (int i = 2; i <= n; i++) {
            int x = i & 1;
            for (int j = 0; j < 10; j++) {
                d[x][j] = 0;
                for (int k : moves[j]) {
                    d[x][j] = (d[x][j] + d[x ^ 1][k]) % MOD;
                }
            }
        }
        int res = 0;
        for (int x : d[n % 2]) {
            res = (res + x) % MOD;
        }
        return res;
    }


}
