package leetcode.order;

import java.util.Arrays;

public class LeetCode1552MaxDistance {

    public static void main(String[] args) {
        LeetCode1552MaxDistance solutions = new LeetCode1552MaxDistance();
        solutions.maxDistance(new int[]{79,74,57,22}, 4);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        // 最小磁力最大值介于[1~最后一个坐标的位置除以m-1]
        int left = 1;
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        int max = 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (valid(position, m, mid)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    /**
     * 判断是否可以间隔num放置m个球
     * @param position      位置坐标
     * @param m             球的数量
     * @param interval      间隔
     * @return 是否可以
     */
    public boolean valid(int[] position, int m, int interval) {
        int nextIndex = position[0] + interval;
        int count = 1;
        // 从position[0]开始加入间隔坐标
        for (int i = 1; i < position.length && count <= m; i++) {
            if (position[i] >= nextIndex) {
                count++;
                nextIndex = position[i] + interval;
            }
        }
        return count >= m;
    }
}
