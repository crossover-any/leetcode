package leetcode.order;

public class LeetCode2012SumOfBeauties {

    public static void main(String[] args) {
        new Solution2().sumOfBeauties(new int[]{2,4,6,4});
    }

    static class Solution1{
        /**
         * 暴力
         *
         * 时间复杂度 O(n^2) 超时
         * @param nums
         * @return
         */
        public int sumOfBeauties(int[] nums) {
            int ans = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                // 第一种情况是否等于2
                // 检查左边是否都小于当前值
                int right = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] >=  nums[i]) {
                        right = 0;
                        break;
                    }
                }
                // 检查右边是否都大于当前值
                int left = 1;
                for (int j =  i + 1; j < nums.length; j++) {
                    if (nums[j] <= nums[i]) {
                        left = 0;
                        break;
                    }
                }
                if (right == 1 && left == 1) {
                    ans = ans + right + left;
                    continue;
                }
                // 判断是否满足第二种情况
                if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    ans++;
                }
            }
            return ans;
        }
    }


    static class Solution2 {
        public int sumOfBeauties(int[] nums) {
            int n = nums.length;
            int[] state = new int[n];
            // 前缀最大值
            int pre_max = nums[0];
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] > pre_max) {
                    state[i] = 1;
                    pre_max = nums[i];
                }
            }
            // 后缀最小值
            int suf_min = nums[n - 1];
            int res = 0;
            for (int i = n - 2; i > 0; i--) {
                if (state[i] == 1 && nums[i] < suf_min) {
                    // state[i] == 1表示 当前数大于左边所有的数
                    // nums[i] < sufmin表示,当前数小于右边最小的数
                    res += 2;
                } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    res += 1;
                }
                suf_min = Math.min(suf_min, nums[i]);
            }
            return res;
        }
    }


}
