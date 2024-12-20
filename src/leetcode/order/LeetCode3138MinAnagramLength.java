package leetcode.order;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode3138MinAnagramLength {

    public int minAnagramLength(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            // s是由若干同位字符串连接而成,那么子串长度肯定是s的因子,必须能被n整除
            if (n % i != 0) {
                continue;
            }
            if (check(s, i)) {
                return i;
            }
        }
        return n;
    }

    public boolean check(String s, int m) {
        int[] count0 = new int[26];
        for (int j = 0; j < s.length(); j += m) {
            // 记录当前子串的字符频数
            int[] count1 = new int[26];
            for (int k = j; k < j + m; k++) {
                count1[s.charAt(k) - 'a']++;
            }
            // 如果出现频次不相等，则不是同位字符串,直接返回false
            if (j > 0 && !Arrays.equals(count0, count1)) {
                return false;
            }
            count0 = count1;
        }
        return true;
    }
}
