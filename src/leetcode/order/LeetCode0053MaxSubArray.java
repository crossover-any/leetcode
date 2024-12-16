package leetcode.order;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 * @author tengxq
 */
public class LeetCode0053MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
