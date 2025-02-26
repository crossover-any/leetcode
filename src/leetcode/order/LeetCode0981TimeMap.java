package leetcode.order;

import java.util.*;

public class LeetCode0981TimeMap {

    class TimeMap {

        Map<String, List<Pairs>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pairs(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pairs> list = map.get(key);
            if (list == null) {
                return "";
            }
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                Pairs pairs = list.get(mid);
                if (pairs.timestamp == timestamp) {
                    return pairs.value;
                } else if (pairs.timestamp > timestamp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == 0) {
                return "";
            }
            return list.get(left - 1).value;
        }
    }

    class Pairs {
        String value;
        int timestamp;

        public Pairs(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
