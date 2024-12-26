package leetcode.order;

/**
 * 最长重复子数组
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 *
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 *
 * @author tengxq
 */
public class LeetCode0718FindLength {

    public static void main(String[] args) {
        LeetCode0718FindLength solution = new LeetCode0718FindLength();
        int[] nums1 = new int[]{0,0,0,0,0,0,1,0,0,0};
        int[] nums2 = new int[]{0,0,0,0,0,0,0,1,0,0};
        System.out.println(solution.findLength(nums1, nums2));
    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[] shortNums = nums1.length > nums2.length ? nums2 : nums1;
        int[] longNums = nums1.length > nums2.length ? nums1 : nums2;
        // 从大到小遍历可能的长度
        for (int i = shortNums.length; i > 0; i--) {
            //取[j, j+i)的子串进行匹配
            for (int j = 0; j + i <= shortNums.length; j++) {
                // 比较长的数组里面是否包含该数组
                int k = j;
                int m = 0;
                for (int l = m; l < longNums.length && k < j + i; l++) {
                    if (longNums[l] == shortNums[k]) {
                        k++;
                    } else {
                        // 如果没匹配上则重置, longNums 的索引从m开始
                        k = j;
                        if (m+i <= longNums.length) {
                            l = m++;
                        }
                    }
                }
                if (k == j + i) {
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * 动态规划
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength2(int[] nums1, int[] nums2) {
        // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
