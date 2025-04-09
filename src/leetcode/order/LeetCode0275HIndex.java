package leetcode.order;

public class LeetCode0275HIndex {

    public static void main(String[] args) {
        LeetCode0275HIndex solution = new LeetCode0275HIndex();
        solution.hIndex(new int[]{0, 1, 1, 2});
    }

    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 升序数组可以优化判断
            if (citations[mid - 1] >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right < 0? Math.min(1, citations[0]) : right;
    }

}
