package leetcode.order;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0257BInaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "->", list);
        return list;
    }

    public void dfs(TreeNode node, String path, List<String> list) {
        if (node.left == null && node.right == null) {
            path += node.val;
            list.add(path.replaceFirst("->", ""));
        }
        path  = path + node.val + "->";
        if (node.left != null) {
            dfs(node.left, path , list);
        }
        if (node.right != null) {
            dfs(node.right, path, list);
        }
    }
}
