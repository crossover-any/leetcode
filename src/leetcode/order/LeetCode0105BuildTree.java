package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0105BuildTree {

    public static void main(String[] args) {
        LeetCode0105BuildTree leetCode0105BuildTree = new LeetCode0105BuildTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = leetCode0105BuildTree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int position, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[position]);

        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(preorder, inorder, position + 1, start, i - 1);
                root.right = buildTree(preorder, inorder, position + i - start + 1, i + 1, end);
                break;
            }
        }
        return root;
    }
}
