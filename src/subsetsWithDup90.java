import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname subsetsWithDup90
 * @Description 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 注意：1 Java的索引机制，res添加新集合进去一定要重新申请一块地址，要不然最后都指向一个地址
 * @Date 2019/11/10 22:13
 * @Created by Tengxq
 */
public class subsetsWithDup90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] mark = new boolean[len];
        List<Integer> pre = new ArrayList<>();
        subset(nums,res,pre,mark,0);
        return res;
    }

    public void subset(int[] nums,List<List<Integer>> res,List<Integer> pre,boolean[] mark,int begin){
        res.add(new ArrayList<>(pre));
        for (int i = begin;i<nums.length;i++){
            if (i>0 && nums[i-1] == nums[i] && !mark[i-1]){
                continue;
            }
            mark[i] = true;
            pre.add(nums[i]);

            subset(nums,res,pre,mark,i+1);

            pre.remove(pre.size()-1);
            mark[i] = false;
        }
    }

    public static void main(String[] args) {
        subsetsWithDup90 solution = new subsetsWithDup90();
        int[] nums = {1,2,2};
        List list = solution.subsetsWithDup(nums);
    }


}
