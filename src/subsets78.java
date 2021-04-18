import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname subsets78
 * @Description TODO
 * @Date 2019/11/10 20:21
 * @Created by Tengxq
 */
public class subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(len == 0 ){
            return res;
        }
        List<Integer> pre = new LinkedList<>();
        findSubset(res,nums,pre,0);
        return res;
    }

    public void findSubset(List<List<Integer>> res,int[] nums,List<Integer> pre,int begin){
        res.add(new ArrayList<>(pre));

        for(int i = begin;i<nums.length;i++){
            pre.add(nums[i]);
            findSubset(res,nums,pre,i+1);
            pre.remove(pre.size()-1);
        }
    }
}
