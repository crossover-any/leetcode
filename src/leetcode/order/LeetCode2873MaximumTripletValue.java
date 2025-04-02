package leetcode.order;

public class LeetCode2873MaximumTripletValue {

    public static void main(String[] args) {
        LeetCode2873MaximumTripletValue solution = new LeetCode2873MaximumTripletValue();
        solution.maximumTripletValue(new int[]{1000000,1,1000000});
    }

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long)(leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }
}
