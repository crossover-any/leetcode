package leetcode.order;

public class LeetCode0704Search {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
