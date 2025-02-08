package leetcode.order;

import java.util.*;

public class LeetCode0049GroupAnagrams {

    public static void main(String[] args) {
        LeetCode0049GroupAnagrams leetCode0049GroupAnagrams = new LeetCode0049GroupAnagrams();
        leetCode0049GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                map.put(key, list);
                res.add(list);
            }
            map.get(key).add(str);
        }
        return res;
    }
}
