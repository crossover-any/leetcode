package leetcode.order;

public class LeetCode2269DivisorSubstring {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;
        int p = 0;
        int q = k - 1;
        while (q < numStr.length()) {
            // 这里也可以用Integer.parseInt(numStr.substring(p, q + 1))
            int divisor = parseNum(numStr, p, q);
            if (divisor != 0 && num % divisor == 0) {
                count++;
            }
            p++;
            q++;
        }
        return count;
    }

    private int parseNum(String str, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = res * 10 + str.charAt(i) - '0';
        }
        return res;
    }
}
