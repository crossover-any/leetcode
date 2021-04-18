import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname combine77
 * @Description TODO
 * @Date 2019/11/12 20:41
 * @Created by Tengxq
 */
public class combine77 {

    private List<List<Integer>> res = new ArrayList();
    private int[] nums;
    public List<List<Integer>> combine(int n, int k) {
        if(n == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
            return res;
        }
        nums = new int[n];
        for(int i = 0; i< n;i++){
            nums[i] = i+1;
        }
        backtrack(0,0,n,k,new Stack<Integer>());
        return res;
    }

    public void backtrack(int depth,int begin,int n,int k,Stack<Integer> stack){
        if(depth == k){
            res.add(new ArrayList(stack));
            return ;
        }
        for(int i = begin ;i<n;i++){
            stack.push(nums[i]);
            backtrack(depth+1,i+1,n,k,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        combine77 test = new combine77();
        test.combine(4,2);
    }
}
