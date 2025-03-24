package leetcode.order;

public class LeetCode2255CountPrefixes {

    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }
}
