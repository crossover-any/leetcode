package leetcode.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2841MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        long max = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            Integer cnt = map.getOrDefault(num, 0);
            sum += num;
            map.put(num, cnt + 1);
            if (i >= k) {
                Integer p = nums.get(i - k);
                Integer pv = map.get(p);
                if (pv == 1) {
                    map.remove(p);
                } else {
                    map.put(p, pv - 1);
                }
                sum -= p;
            }
            if (map.size() >= m) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
