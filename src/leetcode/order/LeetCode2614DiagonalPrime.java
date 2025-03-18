package leetcode.order;

public class LeetCode2614DiagonalPrime {

    public int diagonalPrime(int[][] nums) {
        int max = 0;
        // 找到对角线元素
        for (int i = 0; i < nums.length; i++) {
            // 主对角线元素 nums[i][i]
            if (isPrime(nums[i][i])){
                max = Math.max(max, nums[i][i]);
            }
            // 副对角线元素 nums[i][nums.length - i - 1]
            if (isPrime(nums[i][nums.length - i - 1])) {
                max = Math.max(max, nums[i][nums.length - i - 1]);
            }
        }
        return max;
    }

    private boolean isPrime(int num) {
        if (num <= 2) {
            return false;
        }
        int mid = (int) (Math.sqrt(num) + 1);
        for (int i = 2; i < mid; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
