package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0701DeleteNode {

    public static void main(String[] args) {
        LeetCode0701DeleteNode test = new LeetCode0701DeleteNode();
        // 构造一个二叉树[5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(test.deleteNode(root, 1));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(root == null ? 0 : root.val);
        dummy.left = root;
        dummy.right = root;
        TreeNode node = dummy;
        while (node != null) {
            if (node.left != null && node.left.val == key) {
                node.left = insertNode(node.left.right, node.left.left);
                break;
            }
            if (node.right != null && node.right.val == key) {
                node.right = insertNode(node.right.right, node.right.left);
                break;
            }
            node = node.val > key ? node.left : node.right;
        }
        return dummy.left;
    }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }
        TreeNode p = root;
        while (p != null) {
            if (p.val > node.val) {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return root;
    }
}
