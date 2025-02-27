package leetcode.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0658FindClosestElements {

    public static void main(String[] args) {
        LeetCode0658FindClosestElements solutions = new LeetCode0658FindClosestElements();
        solutions.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = ~index - 1;
        }
        int p = index, q = index + 1;
        while (k > 0) {
            if (p >= 0) {
                if (q == arr.length || Math.abs(arr[p] - x) <= Math.abs(arr[q] - x)) {
                    ans.add(arr[p--]);
                } else {
                    ans.add(arr[q++]);
                }
            } else if(q < arr.length) {
                ans.add(arr[q++]);
            }
            k--;
        }
        ans.sort(Integer::compareTo);
        return ans;
    }
}
