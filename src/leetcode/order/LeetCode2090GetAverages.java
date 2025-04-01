package leetcode.order;

public class LeetCode2090GetAverages {

    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        long sum = 0;
        int length = 2 * k + 1;
        for (int i = 0; i < length - 1 && i < nums.length; i++) {
            sum += nums[i];
        }
        int end = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && i < end) {
                sum += nums[i + k];
                // 注意括号的位置,是对结果进行强转
                ans[i] = (int) (sum/ length);
                sum -= nums[i - k];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
