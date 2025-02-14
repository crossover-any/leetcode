package leetcode.order;

import java.util.Arrays;

public class LeetCode3281MasPossibleScore {

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        // 极端条件下 start[i]相等 d等于0,那么score=0
        int left = 0;
        // 理想条件下 假设start范围是从0-N,每个区间选一个值 那么应该从0, avg, 2avg, ... (n-1)avg
        // score的最大值不会大于平均值
        int right = (start[n - 1] + d - start[0]) / (n - 1);
        int max = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(start, d, mid)) {
                left = mid + 1;
                max = Math.max(mid, max);
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    private boolean check(int[] start, int d, int score) {
        // 假设第一个值选的x 那么第二个值就可以选 x + score、x+score+1 ... max, 所以至少是x+score
        long x = Long.MIN_VALUE;
        for (int s : start) {
            // 第一个值 必选s,因为值越小，后面可操作的空间才大
            // 后续值, x + score  介于[s, s+d]区间，或者x+score < s, 那么 s - (x + score) >= 0
            x = Math.max(x + score, s);
            // 如果对比值x 超过了区间值返回false
            if (x > s + d) {
                return false;
            }
        }
        return true;
    }
}
