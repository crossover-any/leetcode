package leetcode.oneperday._20210421numDecodings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 *
 * @author: tengxq
 * @since: 2021/4/21 9:20
 */
public class NumDecodingsDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings2("1200014"));
    }
}

class Solution {
    private final String STR_ZERO = "0";
    public int numDecodings1(String s) {
        if (s != null && s.length() > 0) {
            int preNum = 0;
            int prePreNum = 0;
            //初始化操作,边界条件，因为遍历时需要知道上一个编码数量和上上一个编码数量
            if (Integer.parseInt(s.substring(0, 1)) != 0) {
                preNum = 1;
                if (s.length() > 1 && Integer.parseInt(s.substring(0,2)) <= 26){
                    prePreNum = 1;
                }
            } else {
                return 0;
            }
            for (int i = 1; i < s.length(); i++) {
                String curStr = s.substring(i, i + 1);//当前数字
                String preStr = s.substring(i - 1, i);//上一个数字
                int num = 0;
                //如果当前数字等于0
                if (curStr.equals(STR_ZERO)) {
                    //如果前一个数字等于0
                    if (preStr.equals(STR_ZERO)) {
                        return 0;
                    } else {
                        num = Integer.parseInt(preStr + curStr);
                        if (num > 26) {
                            return 0;
                        } else {
                            //如果当前数字等于0，前一个数字不等于0，组合合法，编码数量等于前一个数字的数量
                            int temp = preNum;
                            preNum = prePreNum;
                            prePreNum = temp;
                        }
                    }
                } else {
                    if (preStr.equals(STR_ZERO)) {
                        //如果当前数字不等于0，前一个数字等于0，当前编码数量等于前一个数字的数量
                        prePreNum = preNum;
                    } else {
                        num = Integer.parseInt(preStr + curStr);
                        if (num <= 26) {
                            int temp = preNum;
                            preNum = prePreNum + preNum;
                            prePreNum = temp;
                        } else {
                            prePreNum = preNum;
                        }
                    }
                }
            }
            return preNum;
        }
        return 0;
    }

    public int numDecodings2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
