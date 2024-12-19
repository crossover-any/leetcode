package leetcode.order;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0056Merge {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                result.add(intervals[i - 1]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        return result.toArray(new int[result.size()][]);
    }
}
