package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode3206NumberOfAlternatingGroups {



    public int numberOfAlternatingGroups(int[] colors) {
        int cnt = 0;
        int length = colors.length;
        int pre = length - 1;
        for (int i = 0; i < length; i++) {
            if ((colors[i] ^ colors[pre%length]) > 0 && (colors[i] ^ colors[(i + 1)%length]) > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
