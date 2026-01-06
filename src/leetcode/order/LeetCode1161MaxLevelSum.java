package leetcode.order;

import model.TreeNode;

import java.util.LinkedList;

public class LeetCode1161MaxLevelSum {

    public static void main(String[] args) {
        LeetCode1161MaxLevelSum test = new LeetCode1161MaxLevelSum();
        // root = [989,null,10250,98693,-89388,null,null,null,-32127]
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(10250);
        root.right.left = new TreeNode(98693);
        root.right.right = new TreeNode(-89388);
        root.right.right.right = new TreeNode(-32127);
        System.out.println(test.maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        queue.add(root);
        int levelCount = 1;
        int levelSum = 0;
        int maxLevel = 1;
        int curLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();
            levelSum += node.val;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right  != null) {
                queue.add(node.right);
            }
            queue.removeFirst();
            levelCount--;
            if (levelCount == 0) {
                levelCount = queue.size();
                if (levelSum > max) {
                    maxLevel = curLevel;
                    max = levelSum;
                }
                curLevel++;
                levelSum = 0;
            }

        }
        return maxLevel;
    }
}
