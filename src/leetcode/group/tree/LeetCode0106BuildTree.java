package leetcode.group.tree;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0106BuildTree {

    public static void main(String[] args) {
        LeetCode0106BuildTree test = new LeetCode0106BuildTree();
        TreeNode root = test.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int position, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[position]);
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(inorder, postorder, position - (end - i + 1), start, i - 1);
                root.right = buildTree(inorder, postorder, position - 1, i + 1, end);
            }
        }
        return root;
    }

}
