package leetcode.order;

import java.util.Arrays;

public class LeetCode1170NumSmallerByFrequency {

    public static void main(String[] args) {
        LeetCode1170NumSmallerByFrequency solutions = new LeetCode1170NumSmallerByFrequency();
        solutions.numSmallerByFrequency2(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"});
        solutions.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[11];
        for (String s : words) {
            count[f(s)]++;
        }
        for (int i = 9; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            res[i] = count[f(s) + 1];
        }
        return res;
    }

    public int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            nums[i] = f(words[i]);
        }
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = nums.length - searchHigher(nums, f(queries[i]));
        }
        return res;
    }

    private int searchHigher(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    private int f(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        int cnt = 0;
        int min = 'z';
        for (char c : charArray) {
            if (c == min) {
                cnt++;
            } else if (c < min) {
                min = c;
                cnt = 1;
            }
        }
        return cnt;
    }
}
