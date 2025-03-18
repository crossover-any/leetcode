package leetcode.order;

public class LeetCode0875MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(piles, h, mid)) {
                // 如果k值较大，降低K值看是否依然满足
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] piles, int h, int p) {
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += (piles[i] + p - 1)/p;
            if (total > h) {
                return false;
            }
        }
        return true;
    }
}
