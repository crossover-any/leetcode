package leetcode.oneperday._20210428judgeSquareSum;

import java.util.Arrays;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * @author: tengxq
 * @since: 2021/4/28 8:55
 */
public class JudgeSquareSumDemo {
    public static void main(String[] args) {
        String[] es = "1001E1".split("E");
        System.out.println(Arrays.toString(es));
    }
}

class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
