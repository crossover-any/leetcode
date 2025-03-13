package leetcode.order;

public class LeetCode1283SmallestDivisor {

    public static void main(String[] args) {
        LeetCode1283SmallestDivisor solution = new LeetCode1283SmallestDivisor();
        solution.smallestDivisor(new int[]{1,2,5,9}, 6);
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int right = 0;
        int left = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        // 寻找左边小于等于threshold的第一个数
        while (left <= right) {
            int mid = left + (right - left)/2;
            // 如果满足<=threshold 将除数增大，直到不满足
            if (check(nums, mid, threshold)) {
                // 满足的话将除数变小，这样结果会变大
                right = mid - 1;
            } else {
                // 不满足将除数增大，结果变小
                left = mid + 1;
            }
        }
        // 分析left的值，如果mid满足check,那么可以将mid变小一点(right = mid - 1),此时结果会变大,
        // 一直变到mid不满足,此时需要增大mid的值left = mid + 1,
        return left;
    }

    private boolean check(int[] nums, int m, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + m - 1) / m;
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}
