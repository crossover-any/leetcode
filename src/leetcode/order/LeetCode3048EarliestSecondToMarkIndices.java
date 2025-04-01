package leetcode.order;

import java.util.Arrays;

public class LeetCode3048EarliestSecondToMarkIndices {

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        if (n > m) {
            return -1;
        }

        int[] lastT = new int[n];
        int left = n - 1, right = m + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, changeIndices, lastT, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right > m ? -1 : right;
    }

    private boolean check(int[] nums, int[] changeIndices, int[] lastT, int mx) {
        Arrays.fill(lastT, -1);
        for (int t = 0; t < mx; t++) {
            lastT[changeIndices[t] - 1] = t;
        }
        for (int t : lastT) {
            if (t < 0) { // 有课程没有考试时间
                return false;
            }
        }

        int cnt = 0;
        for (int i = 0; i < mx; i++) {
            int idx = changeIndices[i] - 1;
            if (i == lastT[idx]) { // 考试
                if (nums[idx] > cnt) { // 没时间复习
                    return false;
                }
                cnt -= nums[idx]; // 复习这门课程
            } else {
                cnt++; // 留着后面用
            }
        }
        return true;
    }

}
