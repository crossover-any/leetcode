package leetcode.order;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode3296MinNumberOfSeconds {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.minNumberOfSeconds(4, new int[]{2,1,1});

    }

    static class Solution1 {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            for (int t : workerTimes) {
                // 降山的高度降低1高度后的工作总用时，用时增量，基础用时
                pq.offer(new long[]{t, t, t});
            }
            long ans = 0;
            while (mountainHeight-- > 0) {
                // 工作后总用时，当前工作（山高度降低 1）用时，workerTimes[i]
                long[] w = pq.poll();
                long nxt = w[0], delta = w[1], base = w[2];
                // 选择一个花销最小的工人来降低山的高度
                ans = nxt; // 最后一个出堆的 nxt 即为答案
                // 如果下一次选择该工人来降低山的高度，
                // 则花销为 本次花销nxt + 累计值 delta + 基础值
                // delta + base 累积值 1base 2base 3base ...
                // base 基础值，一直不变

                // 疑问？
                // 感觉nxt没有与其他workertime相加，为什么能得到正确结果？
                // 答: 因为是减小山的高度,每次选择的是最优解将山的高度降低，求的是最小时间
                pq.offer(new long[]{nxt + delta + base, delta + base, base});
            }
            return ans;
        }
    }

    static class Solution2 {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            int maxT = 0;
            for (int t : workerTimes) {
                maxT = Math.max(maxT, t);
            }
            int h = (mountainHeight - 1) / workerTimes.length + 1;
            long left = 0;
            long right = (long) maxT * h * (h + 1) / 2;
            while (left + 1 < right) {
                long mid = (left + right) / 2;
                if (check(mid, mountainHeight, workerTimes)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(long m, int leftH, int[] workerTimes) {
            for (int t : workerTimes) {
                leftH -= ((int) Math.sqrt(m / t * 8 + 1) - 1) / 2;
                if (leftH <= 0) {
                    return true;
                }
            }
            return false;
        }
    }

}
