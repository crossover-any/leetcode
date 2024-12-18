package leetcode.order;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tengxq
 */
public class LeetCode0435EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按左边界升序排序 [[1,2],[2,3],[3,4],[1,3]]
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        // 排序后 [[1,2],[1,3],[2,3],[3,4]]
        // 非重复区间数量,这里有个特点是删除最少的区间让区间不重复,那么有效区间则是需要保存较小的区间,那么就需要删除较大的区间
        // 排序前 [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
        // 排序后 [[-73,-26],[-65,-11],[-63,2],[-62,-49],[-52,31],[-40,-26],[-31,49],[30,47],[58,95],[66,98],[82,97],[95,99]]
        int count = 1;
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1]){
                // 这里 min 的意义是 如果两个区间有重叠,那么取较小的区间,因为较小的区间更小,删除的区间更少
                // 例如[-73,-26]在后面找到了更短的区间[-62,-49], [-52,31]替换为[-40,-26]
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }else{
                count++;
            }
        }
        return intervals.length - count;
    }
}
