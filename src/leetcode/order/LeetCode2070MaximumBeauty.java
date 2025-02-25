package leetcode.order;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode2070MaximumBeauty {

    public static void main(String[] args) {
        LeetCode2070MaximumBeauty solution = new LeetCode2070MaximumBeauty();
        //solution.maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}}, new int[]{1,2,3,4,5,6});
        solution.maximumBeauty(new int[][]{{10,1000}}, new int[]{5});
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[queries.length];
        int[] dp = new int[items.length];
        dp[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            dp[i] = Math.max(dp[i - 1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            // 寻找大于等于queries[i]的最后一个元素
            int index = searchHigher(items, queries[i]);
            if (index == -1) {
                ans[i] = 0;
            } else {
                ans[i] = dp[index];
            }
        }
        return ans;
    }

    private int searchHigher(int[][] items, int target) {
        int left = 0;
        int right = items.length - 1;
        while (left  <= right) {
            int mid = (left + right) >>> 1;
            if (items[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

}
