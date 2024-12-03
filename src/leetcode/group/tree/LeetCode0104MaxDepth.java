package leetcode.group.tree;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0104MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
