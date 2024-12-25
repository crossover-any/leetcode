package leetcode.order;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tengxq
 */
public class LeetCode0337Rob {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 偷当前节点
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷当前节点
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 优化递归
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        // 偷当前节点
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷当前节点
        int max = Math.max(money, rob(root.left) + rob(root.right));
        map.put(root, max);
        return max;
    }

    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        // 0 不偷当前节点取得的最大值，1 偷当前节点取得的最大值
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        // 不偷当前节点: 左右子树不偷和偷的最大值之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点: 当前节点的值加上左右子树不偷的值
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
