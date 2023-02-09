package datatruct;

import java.util.Stack;

/**
 * @Classname BinaryTree
 * @Description TODO
 * @Date 2019/11/24 11:54
 * @Created by Tengxq
 */
public class BinaryTree {
    /**
     * 后序遍历 非递归
     * 双栈法
     *
     * @param root
     */
    public static void postOrder2(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.rightNode;
            } else {
                node = stack.pop();
                node = node.leftNode;
            }
        }

        while (output.size() > 0) {
            Node n = output.pop();
            System.out.print(n.data + "\t");
        }
    }

    private class Node {
        public Node rightNode;
        public Node leftNode;
        public int data;
    }
}
