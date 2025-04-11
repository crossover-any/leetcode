package leetcode.order;

import datatruct.ArrayStack;
import datatruct.util.Stack;

public class LeetCode2843CountSymmetricInteger {

    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        int sum = 0;
        for (int i = low; i <= high; i++) {
            String str = i + "";
            if (str.length() %2 == 0) {
                sum = 0;
                for (int j = 0; j < str.length() / 2; j++) {
                    sum += str.charAt(j);
                }
                for (int j = str.length()/2; j < str.length(); j++) {
                    sum -= str.charAt(j);
                }
                if (sum == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
