package leetcode.order;

public class LeetCode1343NumOfSubArrays {

    public static void main(String[] args) {
        LeetCode1343NumOfSubArrays solution = new LeetCode1343NumOfSubArrays();
        solution.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4);
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = k * threshold;
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }
        int ans = cur < sum ? 0 : 1;
        for (int i = k; i < arr.length; i++) {
            cur = cur - arr[i - k] + arr[i];
            if (cur >= sum) {
                ans += 1;
            }
        }
        return ans;
    }
}
