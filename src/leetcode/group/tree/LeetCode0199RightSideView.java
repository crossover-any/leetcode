package leetcode.group.tree;

import model.TreeNode;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0199RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode subNode = queue.poll();
                if (subNode.left != null) {
                    queue.offer(subNode.left);
                }
                if (subNode.right != null) {
                    queue.offer(subNode.right);
                }
                if (i == size - 1) {
                    result.add(subNode.val);
                }
            }
        }
        return result;
    }
}
