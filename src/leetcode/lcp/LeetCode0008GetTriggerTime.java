package leetcode.lcp;

import java.util.Arrays;

public class LeetCode0008GetTriggerTime {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] c = new int[increase.length + 1];
        int[] r = new int[increase.length + 1];
        int[] h = new int[increase.length + 1];
        for (int i = 0; i < increase.length; i++) {
            c[i + 1] = increase[i][0] + c[i];
            r[i + 1] = increase[i][1] + r[i];
            h[i + 1] = increase[i][2] + h[i];
        }
        Arrays.sort(c);
        Arrays.sort(r);
        Arrays.sort(h);
        int[][] ordered = new int[][]{c, r, h};

        int[] ans = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            // 寻找三个最小触发点, 取其最大值
            int k = -1;
            for (int j = 0; j < 3; j++) {
                k = Math.max(binarySearch(ordered[j], requirements[i][j]), k);
                if (k == ordered[j].length) {
                    // 没有触发时机
                    k = -1;
                    break;
                }
            }
            ans[i] = k;
        }
        return ans;
    }

    // 期望: 找到>=target的第一个坐标
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果left = length, 证明target大于所有值
        // 如果left = 0, 证明target小于所有值
        // 如果left>0, < length, 找到了>=target的第一个坐标
        return left;
    }
}
