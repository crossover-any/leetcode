package leetcode.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2610FindMatrix {

    public List<List<Integer>> findMatrix(int[] nums) {
        // 用一个Map来记录数字出现了几次
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        int maxCount = 0;
        for (int num : nums) {
            Integer cnt = countMap.getOrDefault(num, 0);
            maxCount = Math.max(maxCount, ++cnt);
            countMap.put(num, cnt);
        }
        List<List<Integer>> res = new ArrayList<>(maxCount);
        for (int i = 0; i < maxCount; i++) {
            res.add(new ArrayList<>());
        }
        for (int num : nums) {
            Integer i = countMap.get(num);
            if (i == null) {
                continue;
            }
            // 出现了i次
            for (int j = 0; j < i; j++) {
                res.get(j).add(num);
            }
            countMap.remove(num);
        }
        return res;
    }
}
