package leetcode.order;

/**
 * 摆动序列
 *
 * <a href = 'https://leetcode.cn/problems/wiggle-subsequence/description/'>376. Wiggle Subsequence</a>
 *
 * @author tengxq
 */
public class LeetCode0376WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int preDiff = 0;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0 && preDiff <= 0 || diff < 0 && preDiff >= 0) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }
}
