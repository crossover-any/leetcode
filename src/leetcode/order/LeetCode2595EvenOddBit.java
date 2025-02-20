package leetcode.order;

public class LeetCode2595EvenOddBit {

    public static void main(String[] args) {
        LeetCode2595EvenOddBit solution = new LeetCode2595EvenOddBit();
        solution.evenOddBit(17);
    }

    public int[] evenOddBit(int n) {
        int i = 0;
        int[] res = new int[2];
        while (n > 0) {
            res[i] += 1 & n;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }
}
