package leetcode.order;

import model.TreeNode;

/**
 * @author tengxq
 */
public class LeetCode0654ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIndex = start;
        // 找到最大值
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}
