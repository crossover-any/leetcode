package leetcode.order;

import java.util.Arrays;

public class LeetCode2563CountFairPairs {

    public static void main(String[] args) {
        LeetCode2563CountFairPairs solution = new LeetCode2563CountFairPairs();
        solution.countFairPairs(new int[]{0,0,0,0,0,0}, 0, 0);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = searchLower(nums, i, lower - nums[i]);
            int end = searchHigher(nums, i, upper - nums[i]);
            if (end > i + 1) {
                cnt  = cnt + (end -start);
            }
        }
        return cnt;
    }

    // 找到大于等于target的第一个值
    private int searchLower(int[] nums, int start, int target) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 找到大于target的第一个值
    private int searchHigher(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
