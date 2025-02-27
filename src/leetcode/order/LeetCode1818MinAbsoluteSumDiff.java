package leetcode.order;

import java.util.Arrays;

public class LeetCode1818MinAbsoluteSumDiff {

    public static void main(String[] args) {
        LeetCode1818MinAbsoluteSumDiff solution = new LeetCode1818MinAbsoluteSumDiff();
        solution.minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4});
    }

    /**
     * 思路：
     * 1.找到绝对值差最大的地方，
     * 2.然后找与最大值最接近的数替换他
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            // 如果找到target返回target，如果没有则返回小于target的第一个值
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                // 大于等于target的差值
                // rec[j] - nums2[i]为什么不取绝对值？因为j是最靠近i的值有 |nums1[i] - nums2[i]| >= rec[j] - nums2[i]
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                // 小于target的差值
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;

    }

    // 如果找到target返回target，如果没有则返回大于target的第一个值，如果所有值均小于target返回最大的值
    public int binarySearch(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left= 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
