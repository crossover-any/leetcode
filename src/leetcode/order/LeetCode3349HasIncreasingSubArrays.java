package leetcode.order;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LeetCode3349HasIncreasingSubArrays {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cnt = 1, precnt = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++cnt;
            }
            else {
                precnt = cnt;
                cnt = 1;
            }
            // min(precnt, cnt) 取两连续子数组的最小值与K值比较
            ans = max(ans, min(precnt, cnt));
            // 这种情况对应如果当前连续数组的长度已经>=2*k，那么可视为有两个连续子数组
            ans = max(ans, cnt / 2);
            if (ans >= k) {
                return true;
            }
        }
        return false;
    }
}


