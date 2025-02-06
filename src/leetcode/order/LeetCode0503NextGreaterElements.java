package leetcode.order;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0503NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        // 用一个栈记录元素的下标
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0, index  = i; i < 2 * nums.length; i++) {
            index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                ans[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return ans;
    }
}
