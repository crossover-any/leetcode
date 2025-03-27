package leetcode.order;

public class LeetCode1482MinDays {

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int max = 0;
        for (int i : bloomDay) {
            max = Math.max(max, i);
        }
        int left = 0;
        int right = max;
        while (left <= right) {
            int day = (left + right) >>> 1;
            if (check(bloomDay, m , k, day)) {
                right =  day - 1;
            } else {
                left = day + 1;
            }
        }
        return left > max? -1: left;
    }

    private boolean check(int[] bloomDay, int m , int k , int day) {
        int total = 0;
        int cnt = 0;
        for (int bloom : bloomDay) {
            if (day >= bloom) {
                // 盛开了
                cnt+=1;
                if (cnt == k) {
                    total+=1;
                    if (total == m) {
                        return true;
                    }
                    // 置零开始下一束花的制作
                    cnt = 0;
                }
            } else {
                // 无法完成一束花的制作
                cnt = 0;
            }
        }
        return false;
    }
}
