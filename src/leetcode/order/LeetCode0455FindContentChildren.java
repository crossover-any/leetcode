package leetcode.order;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode0455FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int ctn = 0;
        int gIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length && gIndex < g.length; i++) {
            if (g[gIndex] <= s[i]) {
                ctn++;
                gIndex++;
            }
        }
        return ctn;
    }
}
