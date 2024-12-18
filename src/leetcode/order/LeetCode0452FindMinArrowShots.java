package leetcode.order;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tengxq
 */
public class LeetCode0452FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        // 按照开始坐标排序 [[10,16],[2,8],[1,6],[7,12]]
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        // 排序后 [[1,6],[2,8],[7,12],[10,16]]
        int count = 1;
        int arrowIndex = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowIndex) {
                count++;
                arrowIndex = points[i][1];
            }
        }
        return count;
    }
}
