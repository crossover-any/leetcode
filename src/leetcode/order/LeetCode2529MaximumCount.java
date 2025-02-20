package leetcode.order;

public class LeetCode2529MaximumCount {

    public static void main(String[] args) {
        LeetCode2529MaximumCount solutions = new LeetCode2529MaximumCount();
        solutions.maximumCount(new int[]{-2,-1,-1,1,2,3});
    }

    public int maximumCount(int[] nums) {
        int start = searchLower(nums, 0);
        int end = searchHigher(nums, 0);
        return Math.max(start, nums.length - end);
    }

    /**
     * 返回大于等于target第一次出现的位置
     * 1.如果target存在nums数组中，则返回target第一次出现的下标
     * 2.如果target不存在nums数组中,返回大于target的第一个数的下标
     *
     * @param nums
     * @param target
     * @return
     */
    private int searchLower(int[] nums, int target) {
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
        return left;
    }

    /**
     * 查找
     * @param nums
     * @param target
     * @return
     */
    private int searchHigher(int[] nums, int target) {
        int left = 0;
        int right= nums.length - 1;
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
