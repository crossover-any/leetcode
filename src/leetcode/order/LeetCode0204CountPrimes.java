package leetcode.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0204CountPrimes {

    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                // 最小的质数来表示一个合数
                isPrime[i * primes.get(j)] = 0;
                // 如果当前质数能够被i整除，表示已经遇到最小的质数 pi*a = i, 不需要继续标识，则跳出循环
                // 假设这里不继续会发生什么情况，令primes{i}*a = i,
                // 那么继续标识的话，primes{i+1} * i = primes{i+1} * primes{i} * a，其实最后就是用primes{i}乘了一个更大的数，
                // 这里又重复表示了，所以这里不需要继续标识。
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
