package sort;

import java.util.Arrays;

/**
 * @Classname Select
 * @Description TODO
 * @Date 2019/11/4 23:05
 * @Created by Tengxq
 */
public class Select {
    public static void main(String[] args) {
        int[] nums = {1, 52, 51, 44, 95, 35, 55, 41, 85, 63};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = nums[j] > nums[max] ? j : max;
            }
            swap(nums, max, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
