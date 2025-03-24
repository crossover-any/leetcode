package leetcode.order;

public class LeetCode1456MaxVowels {

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        for (int i = k; i < s.length(); i++) {
            if (max == k) {
                return max;
            }
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count --;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
