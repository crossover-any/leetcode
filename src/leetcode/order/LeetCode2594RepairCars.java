package leetcode.order;

import java.util.Arrays;

public class LeetCode2594RepairCars {

    public static void main(String[] args) {
        LeetCode2594RepairCars solution = new LeetCode2594RepairCars();
        long l = solution.repairCars(new int[]{3}, 52);
        System.out.println(l);
    }

    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1;
        // 最大值等于让
        long right = 1l * ranks[0] * cars * cars/ranks.length;
        while (left <= right) {
            long minutes = (left + right) >>> 1;
            if (check(ranks, cars, minutes)) {
                right = minutes - 1;
            } else {
                left = minutes + 1;
            }
        }
        return left;
    }

    private boolean check(int[] ranks, int cars, long minutes) {
        long cnt = 0;
        for (int i = ranks.length - 1; i >=0; i--) {
            cnt += (long) Math.sqrt(minutes/ranks[i]);
            if (cnt >= cars) {
                return true;
            }
        }
        return false;
    }
}
