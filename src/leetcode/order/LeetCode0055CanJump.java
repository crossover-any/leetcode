package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0055CanJump {

    /**
     * 55. 跳跃游戏
     * 贪心：从前往后遍历，记录能到达的最远位置，如果当前位置大于等于最远位置，则返回true，否则返回false
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 记录能到达的最远位置
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                // 当前位置不可达,因为K<i
                return false;
            }
            // 最远位置=当前位置 | 当前位置能跳的最远距离
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
