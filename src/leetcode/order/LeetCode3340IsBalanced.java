package leetcode.order;

public class LeetCode3340IsBalanced {

    public boolean isBalanced(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += n;
            } else {
                sum -= n;
            }
        }
        return sum == 0;
    }
}
