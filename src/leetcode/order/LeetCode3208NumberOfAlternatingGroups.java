package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode3208NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int cnt = 0;

        // 枚举右端点从 n-k 到 n-1
        for (int i = n-k; i < 2 * n; i++) {
            if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                cnt = 0;
            }
            cnt++;
            // n-k 到n,可以认为是初始化的过程，从n开始才是真正的枚举过程
            if (i >= n && cnt >= k) {
                ans++;
            }
        }
        return ans;
    }
}
