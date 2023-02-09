package sort;

import java.util.Arrays;

/**
 * @Classname BubbleSort
 * @Description 冒泡排序
 * @Date 2019/11/4 22:46
 * @Created by Tengxq
 */
public class Bubble {
    public static void main(String[] args) {
        int[] nums = {1, 52, 51, 44, 95, 35, 55, 41, 85, 63};
        Bubble(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void Bubble(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
