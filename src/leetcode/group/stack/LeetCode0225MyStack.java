package leetcode.group.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tengxq
 */
public class LeetCode0225MyStack {

    class MyStack {

        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.add(x);
            } else {
                queue1.add(x);
            }
        }

        public int pop() {
            if (queue1.isEmpty()) {
                move(queue2, queue1);
                return queue2.poll();
            } else {
                move(queue1, queue2);
                return queue1.poll();
            }
        }

        public int top() {
            if (queue1.isEmpty()) {
                move(queue2, queue1);
                queue1.add(queue2.peek());
                return queue2.poll();
            } else {
                move(queue1, queue2);
                queue2.add(queue1.peek());
                return queue1.poll();
            }
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        private void move(Queue<Integer> from , Queue<Integer> to) {
            while (!from.isEmpty() && from.size() > 1) {
                to.add(from.poll());
            }
        }
    }
}
