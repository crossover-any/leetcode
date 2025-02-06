package leetcode.order;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode0496NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(new LeetCode0496NextGreaterElement().nextGreaterElement(nums1, nums2));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 用一个栈记录元素的值
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0, len = nums2.length; i < len; i++) {
            // 1. 如果栈为空，直接入栈
            // 2. 如果栈不为空，并且当前元素大于栈顶元素, 则出栈，并且记录信息
            //    这里出栈的意义是, 找到了第一个大于栈顶元素的元素
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
