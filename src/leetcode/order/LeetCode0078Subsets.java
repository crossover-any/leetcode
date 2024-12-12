package leetcode.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0078Subsets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 迭代
     * 主要思想，将大的数组看成最小的数组，例如从[] 再添加一个元素，那么就需要为一致的集合添加新的元素形成新的子集。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                temp.add(newList);
            }
            result.addAll(temp);
        }
        return result;
    }

    /**
     * 二进制序列
     * 记原序列中元素的总数为 n。原序列中的每个数字 a
     * 的状态可能有两种，即「在子集中」和「不在子集中」。我们用 1 表示「在子集中」，0 表示不在子集中，那么每一个子集可以对应一个长度为 n 的 0/1 序列，第 i 位表示 a
     * 然后从0遍历到2^n-1，然后通过二进制序列来判断是否在子集中，如果为1，则添加到结果集中。
     *
     * 例如 nums = [1,2,3] 应该从000到111，那么000为[], 001为[1], 010为[2], 011为[1,2], 100为[3], 101为[1,3], 110为[2,3], 111为[1,2,3]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(t));
        }
        return result;
    }

    /**
     * 回溯
     *
     * @param nums
     * @param start
     */
    public void backtrace(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
        }
    }

}
