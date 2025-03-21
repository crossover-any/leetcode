package leetcode.order;

public class LeetCode2680MaximumOr {

    class Solution1 {
        public long maximumOr(int[] nums, int k) {
            int n = nums.length;
            // suf[i] 表示 nums[i+1] 到 nums[n-1] 的 OR
            int[] suf = new int[n];
            for (int i = n - 2; i >= 0; i--) {
                // 这里suf[n - 1] = 0, 为什么不初始化该值?
                // 通过第21行可以看到 如果遍历到n - 1的时候，suf[i]应该等于0，n-2的时候 suf[n - 2] = nums[n - 1]
                suf[i] = suf[i + 1] | nums[i + 1];
            }

            long ans = 0;
            // pre 表示 nums[0] 到 nums[i-1] 的 OR
            int pre = 0;
            for (int i = 0; i < n; i++) {
                // 前缀与nums[0 ~ i-1] + 当前移动k位后 + 后缀与 nums[i + 1 ~ n - 1]
                ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
                // 前缀与
                pre |= nums[i];
            }
            // 可以数组中最大的值,左移k位吗？
            // 答:不可以，如果该数是数组中最大的数（高位+低位）,假设该数组中有多个与此高位相同，但是低位小于最大数，
            //    如果max左移k位后，低位恰好也是其它数的位，对于整体来说只有高位在发挥作用，如果另一个数的低位，
            //    没有能被其他数的位覆盖，那么移动该数，高位与低位都在发挥作用会增加位与的值
            return ans;
        }
    }

}
