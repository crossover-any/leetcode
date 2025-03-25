package leetcode.order;

import java.util.Arrays;

public class LeetCode0475FindRadius {

    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int ans = 0;
            Arrays.sort(heaters);
            for (int house : houses) {
                int i = Arrays.binarySearch(heaters, house);
                if (i < 0) {
                    i = i * -1 - 1;

                }
                int j = i - 1;
                int leftDistance = j < 0? Integer.MAX_VALUE: house - heaters[j];
                int rightDistance = i == heaters.length? Integer.MAX_VALUE: heaters[i] - house;
                int curDistance = Math.min(leftDistance, rightDistance);
                ans = Math.max(ans, curDistance);
            }
            return ans;
        }

    }
}
