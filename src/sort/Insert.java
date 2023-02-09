package sort;

/**
 * @Classname Insert
 * @Description 插入排序：
 * 思想： 向前面有序的数组插入一个新的元素，
 * @Date 2019/11/13 23:35
 * @Created by Tengxq
 */
public class Insert {

    public void insertSort(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > temp; j++) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }


}
