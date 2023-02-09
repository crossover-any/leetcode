import java.util.Arrays;

/**
 * @Classname Knapsack
 * @Description 背包问题
 * @Date 2019/11/25 23:16
 * @Created by Tengxq
 */
public class Knapsack {
    private int[] prices = {0, 2, 4, 3, 7};
    private int[] weight = {0, 2, 3, 5, 5};
    private int[][] dp;

    public void Sollution() {
        dp = new int[5][11];
        int i = fillForm(4, 10);
        System.out.println(i);
    }

    public int Knapsack01ByRecursion(int n, int capacity) {
        if (dp[n][capacity] > 0) {
            return dp[n][capacity];
        }
        if (capacity == 0 || n == 0) {
            return 0;
        } else if (weight[n] > capacity) {
            dp[n][capacity] = Knapsack01ByRecursion(n - 1, capacity);
        } else {
            int temp1 = Knapsack01ByRecursion(n - 1, capacity);
            int temp2 = Knapsack01ByRecursion(n - 1, capacity - weight[n]) + prices[n];
            dp[n][capacity] = Math.max(temp1, temp2);
        }
        return dp[n][capacity];
    }

    public int fillForm(int n, int capacity) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + prices[i]);
                }
            }
        }
        return dp[4][10];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.Sollution();
    }
}
