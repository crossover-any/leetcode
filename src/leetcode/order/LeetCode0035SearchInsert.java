package leetcode.order;

public class LeetCode0035SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;
        while(left <= right) {
            int mid = (left +right)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
