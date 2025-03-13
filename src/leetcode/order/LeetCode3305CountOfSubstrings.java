package leetcode.order;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3305CountOfSubstrings {

    public static void main(String[] args) {
        LeetCode3305CountOfSubstrings solution = new LeetCode3305CountOfSubstrings();

        System.out.println(solution.countOfSubstrings("iqeaouqi", 2));
    }

    // vowel 元音 consonant辅音
    Map<Character, Integer> vowelMap = new HashMap<>();
   {
        vowelMap.put('a', 0);
        vowelMap.put('e', 0);
        vowelMap.put('i', 0);
        vowelMap.put('o', 0);
        vowelMap.put('u', 0);
    }

    public int countOfSubstrings(String word, int k) {
        int p = 0;
        int q = 0;
        int vowelCount = 0;
        int consonantCount = 0;
        int ans = 0;
        while (q < word.length()) {
            char c = word.charAt(q);
            Integer v = vowelMap.get(c);
            if (v == null) {
                consonantCount++;
            } else {
                if (v == 0) {
                    vowelCount++;
                }
                vowelMap.put(c, v + 1);
            }
            if (vowelCount == vowelMap.size() && consonantCount == k) {
                ans++;
            }
            // 恰好的话是2个 iqeaouq qeaouqi
            // 至少的话是3个 iqeaouq qeaouqi iqeaouqi
            // solution 1求恰好的话不太方便控制边界条件， 需要加上当满足条件时也需要左边进行滑动
            while ((consonantCount > k && p < word.length())) {
                char c1 = word.charAt(p++);
                Integer v2 = vowelMap.get(c1);
                if (v2 == null) {
                    consonantCount--;
                } else {
                    if (v2 == 1) {
                        vowelCount--;
                    }
                    vowelMap.put(c1, v2 - 1);
                }
                if (vowelCount == vowelMap.size() && consonantCount == k) {
                    ans++;
                }
            }
            q++;

        }
        return ans;
    }


    /**
     * 通过求至少包含k个辅音字母的数量减去至少包含k+1个辅音字母的数量 = 恰好包含k个辅音字母的数量
     */
    static class Solution2 {
        public long countOfSubstrings(String word, int k) {
            char[] s = word.toCharArray();
            return f(s, k) - f(s, k + 1);
        }

        /**
         * 至少包含k个辅音字母的数量
         * @param word 字符串
         * @param k    k
         * @return    至少包含k个辅音字母的数量
         */
        private long f(char[] word, int k) {
            long ans = 0;
            // 这里用哈希表实现，替换成数组会更快
            HashMap<Character, Integer> cnt1 = new HashMap<>(); // 每种元音的个数
            int cnt2 = 0; // 辅音个数
            int left = 0;
            for (char b : word) {
                // 统计vowel、consonant的数量
                if ("aeiou".indexOf(b) >= 0) {
                    cnt1.merge(b, 1, Integer::sum); // ++cnt1[b]
                } else {
                    cnt2++;
                }
                // 移除左边界字符直到不满足条件，那么从0-left这些字符串都满足，至少这个条件
                while (cnt1.size() == 5 && cnt2 >= k) {
                    char out = word[left];
                    // 可优化点, 可以用位运算来进行优化
                    if ("aeiou".indexOf(out) >= 0) {
                        if (cnt1.merge(out, -1, Integer::sum) == 0) { // --cnt1[out] == 0
                            cnt1.remove(out);
                        }
                    } else {
                        cnt2--;
                    }
                    left++;
                }
                ans += left;
            }
            return ans;
        }
    }

}
