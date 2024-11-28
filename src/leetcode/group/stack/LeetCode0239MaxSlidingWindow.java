package leetcode.group.stack;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0239MaxSlidingWindow {

    public static void main(String[] args) {
        LeetCode0239MaxSlidingWindow test = new LeetCode0239MaxSlidingWindow();
        int[] ans = test.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        System.out.println(Arrays.toString(ans));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        DecreasingQueue queue = new DecreasingQueue();
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        ans[index++] = queue.getMax();
        for (int i = k; i < nums.length; i++) {
            queue.pop(nums[i - k]);
            queue.push(nums[i]);
            ans[index++] = queue.getMax();
        }

        return ans;
    }

    class DecreasingQueue {
        private Deque<Integer> queue;

        public DecreasingQueue() {
            queue = new ArrayDeque<>();
        }

        public void push(int num) {
            while (!queue.isEmpty() && queue.getLast() < num) {
                queue.removeLast();
            }
            queue.addLast(num);
        }

        public void pop(int value) {
            if (queue.isEmpty() || value == queue.peek()) {
                queue.poll();
            }
        }

        public int getMax() {
            return queue.peek();
        }
    }
}
