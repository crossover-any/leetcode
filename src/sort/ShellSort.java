package sort;

import java.util.Arrays;

/**
 * @Classname ShellSort
 * @Description 希尔排序（插入排序的优化版，对于大量的数据如果采用直接插入排序，效率比较差，可以采用先将数组达到基本有序，然后再插入排序，效率较高）
 * @Date 2019/11/25 21:55
 * @Created by Tengxq
 */
public class ShellSort {
    public void shellSort(int[] nums){
        int N = nums.length;
        for(int gap = N/2;gap>0;gap/=2){
            for (int i = gap; i <N ; i++) {
                int temp = nums[i];
                int j = i-gap;
                while (j>=0 && temp<nums[j]){
                    nums[j+gap] = nums[j];
                    j-=gap;
                }
                nums[j+gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {88,2,55,41,23,65,5,4,9,46};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
