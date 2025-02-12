package leetcode.order;

public class LeetCode1760MinimumSize {

    public int minimumSize(int[] nums, int maxOperations) {
        // 最小开销是1即每个袋子至少有一个球
        int left = 1;
        // 最大开销是数组中的最大值, 因为如果每个袋子都是这个值，或者有多个该值,但是操作数无法将其化小
        int right = getMax(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canSplit(int[] nums, int maxBagSize, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            // 对大于maxBagSize的数进行操作
            if (num > maxBagSize) {
                // 这里是num - 1, 因为如果num=maxBagSize,实际需要操作num/maxBagSize次,但是这里会多加一次操作,所以需要减1
                operations += (num - 1) / maxBagSize;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
