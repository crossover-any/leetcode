package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0530GetMinimumDifference {

    private Integer pre = null;

    private int minAbs = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minAbs;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre != null) {
            minAbs = Math.min(minAbs, root.val - pre);
        }
        pre = root.val;
        traverse(root.right);
    }
}
