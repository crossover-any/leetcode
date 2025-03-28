package leetcode.order;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2716MinimizedStringLength {

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
