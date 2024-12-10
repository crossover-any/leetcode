package leetcode.group.tree;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0538ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
