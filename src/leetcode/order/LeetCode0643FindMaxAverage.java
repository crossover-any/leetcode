package leetcode.order;

public class LeetCode0643FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return (double) max / k;
    }
}
