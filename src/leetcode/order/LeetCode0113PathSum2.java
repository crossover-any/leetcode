package leetcode.order;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0113PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root.left == null && root.right == null && sum == root.val) {
            path.add(root.val);
            result.add(path);
        }
        if (root.left != null) {
            List<Integer> leftPath = new ArrayList<>(path);
            leftPath.add(root.val);
            dfs(root.left, sum - root.val, leftPath, result);
        }
        if (root.right != null) {
            List<Integer> rightPath = new ArrayList<>(path);
            rightPath.add(root.val);
            dfs(root.right, sum - root.val, rightPath, result);
        }
    }
}
