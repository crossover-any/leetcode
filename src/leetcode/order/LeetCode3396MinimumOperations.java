package leetcode.order;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3396MinimumOperations {

    public static void main(String[] args) {
        LeetCode3396MinimumOperations solutions = new LeetCode3396MinimumOperations();
        solutions.minimumOperations(new int[]{1,2,3,4,2,3,3,5,7});
    }

    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer i = map.getOrDefault(num, 0);
            map.put(num, ++i);
        }
        // 只有1个的直接移除
        map.entrySet().removeIf(next -> next.getValue() == 1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i = i+3) {
            if (map.isEmpty()) {
                return cnt;
            }
            cnt++;
            for (int j = i; j < i + 3 && j < nums.length; j++) {
                Integer i1 = map.get(nums[j]);
                if (i1 != null) {
                    if (i1 > 2) {
                        map.put(nums[j], i1 - 1);
                    } else {
                        map.remove(nums[j]);
                    }
                }
            }

        }
        return cnt;
    }

    class Solution {
        public int minimumOperations(int[] nums) {
            boolean[] seen = new boolean[128];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (seen[nums[i]]) {
                    return i / 3 + 1;
                }
                seen[nums[i]] = true;
            }
            return 0;
        }
    }



}
