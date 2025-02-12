package leetcode.order;

public class LeetCode0744NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int i = binarySearch(letters, target);
        return i == letters.length? letters[0]: letters[i];
    }

    public int binarySearch(char[] letters, char target) {
        int left = 0;
        int right = letters.length -1 ;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
