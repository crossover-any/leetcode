package leetcode.oneperday._20210419RemoveElement;

/**
 * 题目：给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 解题思路1：双指针法，如果当前元素不等于删除元素，则添加进数组
 *
 *
 * @author: tengxq
 * @since: 2021/4/19 15:20
 */
public class RemoveElementDemo {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};

    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
