package leetcode.group.tree;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0098IsValidBST {

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

}
