package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0110IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
