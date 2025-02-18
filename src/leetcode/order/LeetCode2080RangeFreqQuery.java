package leetcode.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2080RangeFreqQuery {

    class RangeFreqQuery {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        /**
         * [left, right]范围内value的出现次数
         */
        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) {
                return 0;
            }
            // 大于等于left的第一个坐标值
            int l = queryLower(list, left);
            // 大于等于left的最后一个坐标值
            int r = queryUpper(list, right);
            return r - l;
        }

        /**
         * 找到target在left至right中出现的第一个位置
         */
        private int queryLower(List<Integer> list, int target) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (list.get(mid) >= target) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 找到大于target的最后一个位置
         */
        private int queryUpper(List<Integer> list, int target) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (list.get(mid) <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
