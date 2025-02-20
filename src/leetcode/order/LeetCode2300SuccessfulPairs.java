package leetcode.order;

import java.util.Arrays;

public class LeetCode2300SuccessfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            // 寻找success需要的最小值第一次出现的坐标
            int index = search(potions, (success + spells[i] - 1) / spells[i]);
            // 大于等于index坐标的数都满足success
            res[i] = potions.length - index;
        }
        return res;
    }

    public int search(int[] positons, long target) {
        int left = 0;
        int right = positons.length - 1;
        while (left <= right) {
            int mid  = (left + right) >>> 1;
            if (positons[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
