package leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tengxq
 */
public class Prime {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 为什么使用 i * i <= num
     * 数学原理：
     * 如果一个数 num 不是质数，那么它一定可以表示为两个因数的乘积，即 num = a * b。
     * 假设 a 和 b 都大于 sqrt(num)，那么 a * b 会大于 num，这与 num = a * b 矛盾。
     * 因此，至少有一个因数小于或等于 sqrt(num)。
     * 优化循环：
     * 如果我们在 for 循环中检查到 i 大于 sqrt(num)，那么我们已经检查了所有可能的小于或等于 sqrt(num) 的因数。
     * 因此，我们可以停止检查，因为如果 num 有因数，它一定已经被找到了
     *
     * @param n
     * @return
     */
    public static boolean isPrime2(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime2(i)) {
                ans++;
            }
        }
        return ans;
    }

    public static int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public int countPrimes3(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
