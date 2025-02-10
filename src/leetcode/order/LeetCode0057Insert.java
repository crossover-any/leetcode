package leetcode.order;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0057Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // -1 未进行合并 0查找右区间中 1 待合并 2合并完成
        int merged = -1;
        int mergedStart = newInterval[0], mergedEnd = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (merged == 2) {
                res.add(intervals[i]);
                continue;
            } else if (merged == 0) {
                if (newInterval[1] <= intervals[i][1]) {
                    mergedEnd = newInterval[1] < intervals[i][0]? newInterval[1]: intervals[i][1];
                    merged = 1;
                }
            } else {
                if (intervals[i][1] < newInterval[0]) {
                    res.add(intervals[i]);
                } else {
                    // 插入的区间有可能是该区间的前一个区间，有可能是交叉区间
                    mergedStart = Math.min(newInterval[0], intervals[i][0]);
                    if (newInterval[1] > intervals[i][1]) {
                        // 还需继续合并看下一个区间的值才能确定
                        merged = 0;
                    }  else {
                        if (newInterval[1] < intervals[i][0]) {
                            mergedEnd = newInterval[1];
                        } else {
                            mergedEnd = intervals[i][1];
                        }
                        merged = 1;
                    }
                }
            }
            if (merged == 1) {
                res.add(new int[]{mergedStart, mergedEnd});
                if (mergedEnd < intervals[i][0] || mergedStart > intervals[i][1]) {
                    res.add(intervals[i]);
                }
                merged = 2;
            }
        }

        // 两种极端情况，在首尾进行插入
        if (merged <= 0) {
            res.add(new int[]{mergedStart, mergedEnd});
        }

        return res.toArray(new int[res.size()][]);
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

}
