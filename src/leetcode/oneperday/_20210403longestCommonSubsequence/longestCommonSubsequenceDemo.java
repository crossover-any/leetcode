package leetcode.oneperday._20210403longestCommonSubsequence;

import datatruct.util.Stack;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 * @author: tengxq
 * @since: 2021-04-03 20:28
 */
public class longestCommonSubsequenceDemo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int commonlen = 0;
        if (null == text1 || null == text2 || "".equals(text1) || "".equals(text2)){
            return commonlen;
        } else {

        }
        return commonlen;
    }
}
