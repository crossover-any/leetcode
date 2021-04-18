package backtracking;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Classname permute46
 * @Description TODO
 * @Date 2019/11/6 20:08
 * @Created by Tengxq
 */
public class permute46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        boolean[] visited = new boolean[nums.length];
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        generatePermution(nums,visited,0,path,res);
        return res;
    }

    public void generatePermution(int[] nums, boolean[] visited, int curSize, Stack path,List<List<Integer>> res){
        if (curSize == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i<nums.length;i++){
            if (!visited[i]){
                visited[i] = true;
                path.push(nums[i]);
                generatePermution(nums,visited,curSize+1,path,res);
                visited[i] = false;
                path.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        String s = "hello";
        s.toCharArray();
        Map dic = new HashMap<Character,Character>();
        dic.put('a','a');
        dic.put('e','e');
        dic.put('i','i');
        dic.put('o','o');
        dic.put('u','u');
        dic.put('A','a');
        dic.put('E','e');
        dic.put('I','i');
        dic.put('O','o');
        dic.put('U','u');
        char[] arr = s.toCharArray();
        int p = 0;
        int q = s.length()-1;
        char temp;
        while(p<q){
            while(dic.get(arr[p]) == null && p<q){
                p++;
            }
            while(dic.get(arr[q]) == null && p<q){
                q--;
            }
            if(p<q){
                temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;

            }
        }
        TreeMap<Integer,Integer> map = new TreeMap();
    }
}
