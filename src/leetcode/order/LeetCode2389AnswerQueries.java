package leetcode.order;

import java.util.Arrays;

public class LeetCode2389AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            // 变成前缀和
            nums[i] = nums[i - 1] + nums[i];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int j = Arrays.binarySearch(nums, queries[i]);
            if (j < 0) {
                j = ~j;
            } else {
                j++;
            }
            answer[i] = j;
        }
        return answer;
    }

}
