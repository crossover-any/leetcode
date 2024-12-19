package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0509Fib {

    /**
     * 递归解法
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /**
     * 优化动态规划解法
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }


}
