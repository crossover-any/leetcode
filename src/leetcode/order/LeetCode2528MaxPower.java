package leetcode.order;

import java.util.Arrays;

public class LeetCode2528MaxPower {

    public static void main(String[] args) {
        LeetCode2528MaxPower leetCode2528MaxPower = new LeetCode2528MaxPower();
        leetCode2528MaxPower.maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2);
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] sum = new long[n + 1]; // 前缀和
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stations[i];
        }
        long mn = Long.MAX_VALUE;
        long[] power = new long[n]; // 电量
        for (int i = 0; i < n; i++) {
            // i+r+1 其中i+r是能够到达的位置但是前缀和是i+r-1范围的,所以这里取i+r+1获取到i+r的能量
            // i-r 是i-r-1位置的和，我们要求的是i-r.. i..i+r
            power[i] = sum[Math.min(i + r + 1, n)] - sum[Math.max(i - r, 0)];
            // 求的最小电量
            mn = Math.min(mn, power[i]);
        }

        long left = mn;
        // 最大值为在最小电量城市新建全部的k个电站, +1是开区间无法取值
        long right = mn + k + 1; // 开区间写法
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, power, n, r, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(long minPower, long[] power, int n, int r, int k) {
        long[] diff = new long[n + 1]; // 差分数组
        long sumD = 0, need = 0;
        for (int i = 0; i < n; ++i) {
            sumD += diff[i]; // 累加差分值
            // 差分电量 = 最小电量 - 目前电量 - 累加差分值
            long m = minPower - power[i] - sumD;
            if (m > 0) { // 需要 m 个供电站
                need += m;
                if (need > k) {
                    return false; // 提前退出这样快一些
                }
                sumD += m; // 差分更新
                if (i + r * 2 + 1 < n) {
                    diff[i + r * 2 + 1] -= m; // 差分更新
                }
            }
        }
        return true;
    }
}
