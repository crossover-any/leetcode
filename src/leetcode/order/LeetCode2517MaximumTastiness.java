package leetcode.order;

import java.util.Arrays;

public class LeetCode2517MaximumTastiness {

    public static void main(String[] args) {
        LeetCode2517MaximumTastiness solutions = new LeetCode2517MaximumTastiness();
        solutions.maximumTastiness(new int[]{1,3,1}, 2);
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0;
        int right = price[n - 1]/(k - 1);
        int max = 0;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (check(price, k, mid)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    public boolean check(int[] price, int k, int num) {
        int cnt = 1;
        int pre = price[0];
        for (int i = 1; i < price.length && cnt < k; i++) {
            if (price[i] - pre >= num) {
                pre = price[i];
                cnt++;
            }
        }
        return cnt == k;
    }
}
