package leetcode.order;

public class LeetCode2379MinimumRecolors {

    public static void main(String[] args) {
        LeetCode2379MinimumRecolors solution = new LeetCode2379MinimumRecolors();
        solution.minimumRecolors("WBWBBBW", 2);
    }

    public int minimumRecolors(String blocks, int k) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                cur++;
            }
        }
        int res = cur;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                cur++;
            }

            if (blocks.charAt(i - k) == 'W') {
                cur--;
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}
