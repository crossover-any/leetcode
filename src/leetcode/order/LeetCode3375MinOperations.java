package leetcode.order;

public class LeetCode3375MinOperations {

    public int minOperations(int[] nums, int k) {
        boolean[] dic = new boolean[100];
        int cnt = 0;
        for (int num : nums) {
            if (num >= k) {
                if (num >k && !dic[num]) {
                    cnt++;
                    dic[num] = true;
                }
            } else {
                return -1;
            }
        }
        return cnt;
    }
}
