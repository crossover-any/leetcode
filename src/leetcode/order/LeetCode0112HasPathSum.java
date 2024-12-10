package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0112HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int sum) {
        //到达叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        //左孩子为 null
        if (root.left == null) {
            return hasPathSumHelper(root.right, sum - root.val);
        }
        //右孩子为 null
        if (root.right == null) {
            return hasPathSumHelper(root.left, sum - root.val);
        }
        return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
    }
}
