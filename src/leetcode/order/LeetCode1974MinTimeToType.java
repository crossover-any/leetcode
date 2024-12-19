package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode1974MinTimeToType {

    public int minTimeToType(String word) {
        char[] chars = word.toCharArray();
        // 初始化=键入时间,后续就无须处理
        int ans = chars.length;
        int last = 'a';
        for (int i = 0; i < chars.length; i++) {
            int min = Math.min(Math.abs(last - chars[i]), 26 - Math.abs(last - chars[i]));
            ans += min;
            last = chars[i];
        }
        return ans;
    }
}
