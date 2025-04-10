package leetcode.order;

public class LeetCode2226MaximumCandies {

    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
            right = Math.max(right, candy);
        }
        if (sum < k) {
            return 0;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(candies, k , mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] candies, long k, int target) {
        if (target == 0) {
            return true;
        }
        long sum = 0;
        for (int candy : candies) {
            sum += candy/target;
            if (sum >= k) {
                return true;
            }
        }
        return false;
    }
}
