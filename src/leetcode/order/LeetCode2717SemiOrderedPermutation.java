package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode2717SemiOrderedPermutation {

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index1 = i;
            }
            if (nums[i] == n) {
                index2 = i;
            }
        }
        int step1 = index1;
        int step2 = index1 > index2 ? n - index2 - 2 : n - index2 -1;
        return step1 + step2;
    }
}
