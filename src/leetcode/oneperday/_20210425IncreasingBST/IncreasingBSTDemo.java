package leetcode.oneperday._20210425IncreasingBST;

import model.TreeNode;

/**
 * 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author: tengxq
 * @since: 2021/4/25 17:01
 */
public class IncreasingBSTDemo {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n5.left = n3;
        n5.right = n6;
        n3.left = n2;
        n3.right = n4;
        n6.right = n8;
        n2.left = n1;
        n8.left = n7;
        n8.right = n9;
        Solution solution = new Solution();
        solution.increasingBST(n5);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return InOrder(root);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private TreeNode InOrder(TreeNode root) {
        TreeNode node = null;
        if (root != null) {

        }
        return null;
    }
}
