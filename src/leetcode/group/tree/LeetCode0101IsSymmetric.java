package leetcode.group.tree;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author tengxq
 */
public class LeetCode0101IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        while (curLeft != null || !stackLeft.isEmpty() || curRight!=null || !stackRight.isEmpty()) {
            // 节点不为空一直压栈
            while (curLeft != null) {
                stackLeft.push(curLeft);
                curLeft = curLeft.left; // 考虑左子树
            }
            while (curRight != null) {
                stackRight.push(curRight);
                curRight = curRight.right; // 考虑右子树
            }
            //长度不同就返回 false
            if (stackLeft.size() != stackRight.size()) {
                return false;
            }
            // 节点为空，就出栈
            curLeft = stackLeft.pop();
            curRight = stackRight.pop();

            // 当前值判断
            if (curLeft.val != curRight.val) {
                return false;
            }
            // 考虑右子树
            curLeft = curLeft.right;
            curRight = curRight.left;
        }
        return true;
    }
}
