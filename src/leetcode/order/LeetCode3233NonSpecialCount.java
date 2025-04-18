package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode3233NonSpecialCount {

    // sqrt(10^9)
    private static final int MX = 31622;
    // 质数前缀和
    private static final int[] PI = new int[MX + 1];

    static {
        for (int i = 2; i <= MX; i++) {
            if (PI[i] == 0) { // i 是质数
                PI[i] = PI[i - 1] + 1;
                // 为什么从i*i开始，因为 i 之前的质数已经处理完毕，不需要再处理了例如 i*(i-1,i-2)
                for (int j = i * i; j <= MX; j += i) { // 注：如果 MX 比较大，小心 i*i 溢出
                    PI[j] = -1; // 标记 i 的倍数为合数
                }
            } else {
                PI[i] = PI[i - 1];
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        return r - l + 1 - (PI[(int) Math.sqrt(r)] - PI[(int) Math.sqrt(l - 1)]);
    }
}
