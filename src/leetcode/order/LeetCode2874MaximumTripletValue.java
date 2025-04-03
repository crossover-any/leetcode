package leetcode.order;

public class LeetCode2874MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {
        long iMax = 0;
        long dMax = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dMax * nums[i]);
            dMax = Math.max(dMax, iMax - nums[i]);
            iMax = Math.max(iMax, nums[i]);
        }
        return res;
    }
}
