package leetcode.order;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        // 用一个栈记录元素的下标
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0, len = temperatures.length; i < len; i++) {
            // 1. 如果栈为空，直接入栈
            // 2. 如果栈不为空，并且当前元素大于栈顶元素，则出栈，并且计算出栈元素的下标与当前元素的下标之差，即为结果
            //    这里出栈的意义是, 找到了第一个大于栈顶元素的元素
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
