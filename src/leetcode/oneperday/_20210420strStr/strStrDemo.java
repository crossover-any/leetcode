package leetcode.oneperday._20210420strStr;

/**
 * 实strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 * @author: tengxq
 * @since: 2021/4/20 11:04
 */
public class strStrDemo {
    public static void main(String[] args) {
       String haystack = "aaaaa", needle = "bba";
        Solution solution = new Solution();
        char[] chars = "".toCharArray();
        System.out.println(solution.m1(haystack,needle));
        
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        return 0;
    }

    /**
     * 暴力法 时间复杂度 O(N*N)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int m1(String haystack, String needle) {
        if (needle != null && haystack != null ){
            if ("".equals(needle) || "".equals(haystack)){
                if ("".equals(needle) && "".equals(haystack)){
                    return 0;
                }else {
                    return -1;
                }
            }
            char[] haystackArr = haystack.toCharArray();
            char[] needleArr = needle.toCharArray();
            int p = needleArr.length-1;
            int q = haystackArr.length-1;
            boolean flag = false;
            while ( p >= 0 && q >= 0 ){
                if (needleArr[p] == haystackArr[q]) {
                    flag = true;
                    while ( p >= 0 && q >= 0 ){
                        if (needleArr[p] == haystackArr[q]) {
                            p--;
                            q--;
                        }else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag){
                    return ++q;
                }else {
                    p = needle.length()-1;
                    q--;
                }
            }
            return -1;
        }
        return 0;
    }
}
