package leetcode.order;

public class LeetCode3516FindClosest {

    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a == b) {
            return 0;
        }
        return a > b? 2: 1;
    }
}
