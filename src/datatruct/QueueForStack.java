package datatruct;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname QueueForStack
 * @Description TODO
 * @Date 2019/11/13 22:37
 * @Created by Tengxq
 */
public class QueueForStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        stack2.clear();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int first = stack2.peek();
        stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }

    public static void main(String[] args) {
        QueueForStack queue = new QueueForStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
