package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0045Jump {

    public int jump(int[] nums) {
        int step = 0;
        int q = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            q = Math.max(q, nums[i] + i);
            if (i == maxPosition) {
                maxPosition = q;
                step++;
            }
        }
        return step;
    }
}
