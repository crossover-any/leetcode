package leetcode.order;

public class LeetCode1870MinSpeedOnTime {



    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) {
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i : dist) {
            right = Math.max(right, i);
        }
        right = (int) Math.ceil(right / (hour - Math.floor(hour)));
        while (left <= right) {
            int speed = (left + right) >>> 1;
            if (check(dist, hour, speed)) {
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }

    private boolean check(int[] dist, double hour, int speed) {
        double sum = 0;
        for (int i = 0; i < dist.length; i++) {
            int d = dist[i];
            double s = (double) d / speed;
            if (i == dist.length - 1) {
                sum += s;
            } else {
                sum += Math.ceil(s);
            }
            if (sum > hour) {
                return false;
            }
        }
        return true;
    }

}
