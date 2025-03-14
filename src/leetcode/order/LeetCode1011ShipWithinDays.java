package leetcode.order;

public class LeetCode1011ShipWithinDays {

    public static void main(String[] args) {
        LeetCode1011ShipWithinDays solution = new LeetCode1011ShipWithinDays();
        System.out.println(solution.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;
        for (int weight : weights) {
            right = Math.max(right, weight);
        }
        // days天装完, 一天就得装(weights.length /days + 1)个货物，每个货物最大重right
        right = (weights.length /days + 1)*right;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(weights, days, mid)) {
                // 满足计划天数,减轻船的装载能力
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] weights, int targetDays, int shipWeight) {
        int actualDays = 0;
        int n = 0;
        for (int weight : weights) {
            // 单个货物大于船的装载能力
            if (shipWeight < weight) {
                return false;
            }
            n+=weight;
            if (n > shipWeight) {
                // 超载
                actualDays++;
                n = weight;
            } else if (n == shipWeight) {
                actualDays++;
                n = 0;
            }
            if (actualDays > targetDays) {
                return false;
            }
        }
        if (n > 0) {
            actualDays++;
        }
        return actualDays <= targetDays;
    }
}
