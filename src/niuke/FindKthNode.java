package niuke;


import model.TreeNode;

/**
 * @Classname FindKthNode
 * @Description TODO
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4
 * @Date 2020/1/4 18:43
 * @Created by Tengxq
 */
public class FindKthNode {
    TreeNode kthNode = null;
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return kthNode;
        }
        index = 0;
        findKthNode(pRoot, k);
        return kthNode;
    }

    void findKthNode(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        findKthNode(node.left, k);
        if (index == k) {
            kthNode = node;
            return;
        }
        index++;
        findKthNode(node.right, k);

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        FindKthNode test = new FindKthNode();
        System.out.println(test.KthNode(node1, 1).val);
    }
}
