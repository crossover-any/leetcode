package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode1038BstToGst {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

}
