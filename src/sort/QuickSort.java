package sort;

import java.util.Arrays;

/**
 * @Classname QuickSort
 * @Description TODO
 * @Date 2019/11/26 22:17
 * @Created by Tengxq
 */
public class QuickSort {

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int base = nums[low];
            int p = low;
            int q = high;
            while (p < q) {
                while (nums[q] >= base && p < q) {
                    q--;
                }
                nums[p] = nums[q];
                while (nums[p] <= base && p < q) {
                    p++;
                }
                nums[q] = nums[p];
            }
            nums[p] = base;
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86};
        QuickSort test = new QuickSort();
        test.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
