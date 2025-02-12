package leetcode.order;

public class LeetCode0034SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int index = binarySearch(nums, target);
        if (index != -1){
            int left = index - 1;
            while (left >= 0) {
                if (nums[left] != target) {
                    break;
                }
                left--;
            }
            int right = index + 1;
            while (right < nums.length) {
                if (nums[right] != target) {
                    break;
                }
                right++;
            }
            res[0] = left + 1;
            res[1] = right - 1;
        }
        return res;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
