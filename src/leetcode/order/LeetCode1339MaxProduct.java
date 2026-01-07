package leetcode.order;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode1339MaxProduct {

    public static void main(String[] args) {
        // root = [1,2,3,4,5,6]
        LeetCode1339MaxProduct test = new LeetCode1339MaxProduct();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        test.maxProduct(n1);
    }


    private int sum = 0;
    private int best = 0;

    public int maxProduct(TreeNode root) {
        // 得到sum_r
        dfs(root);
        // 已知 a+b = sum_r, 找到相邻两个点的和最接近也就是说差值最小
        dfs2(root);
        return (int)((long)best * (sum - best) % 1000000007);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        sum += node.val;
    }

    private int dfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs2(node.left);
        int right = dfs2(node.right);
        int cur = left + right + node.val;
        if (Math.abs(sum - cur - cur) <  Math.abs(sum - best - best)) {
            best = cur;
        }
        return cur;
    }
}
