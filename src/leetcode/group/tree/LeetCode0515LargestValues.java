package leetcode.group.tree;

import model.TreeNode;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0515LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode subNode = queue.poll();
                max = Math.max(max, subNode.val);
                if (subNode.left != null) {
                    queue.offer(subNode.left);
                }
                if (subNode.right != null) {
                    queue.offer(subNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
