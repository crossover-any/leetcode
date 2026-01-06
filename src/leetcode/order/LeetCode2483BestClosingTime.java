package leetcode.order;

public class LeetCode2483BestClosingTime {

    public static void main(String[] args) {
        LeetCode2483BestClosingTime solution = new LeetCode2483BestClosingTime();
        solution.bestClosingTime("YYYY");
    }

    /**
     * 解题思路：
     * 计算在I关门的代价= [i+1, length]中Y的数量 + [0, i]中N的数量
     * 所以遍历到i时对比值大小
     *
     * @param customers
     * @return
     */
    public int bestClosingTime(String customers) {
        int minTime = customers.length();
        int minCost = customers.length();
        //a[i] 表示从0~i有多少个N
        int[] a = new int[customers.length() + 1];
        //b[i] 表示匆匆i~length有多少个Y
        int[] b = new int[customers.length() + 1];
        char[] array = customers.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int v = array[i] == 'N'? 1: 0;
            a[i + 1] = a[i] + v;

            int i2 = array.length - i - 1;
            int v2 = array[i2] == 'Y'? 1: 0;
            b[i2] = b[i2 + 1] + v2;
        }

        for (int i = 0; i < a.length; i++) {
            int cur = a[i] + b[i];
            if (cur < minCost) {
                minCost  = cur;
                minTime = i;
            }
        }
        return minTime;
    }

    /**
     *
     * @param customers
     * @return
     */
    public int bestClosingTime2(String customers) {
        int n = customers.length();
        // 统计Y的数量
        int suf = 0;
        // 统计N的数量
        int pre = 0;
        int minCost = 0;
        int res = 0;

        for (int i = 0; i <= n; i++) {
            // suf + pre 表示当前区间[0,i-1]最大代价，如果已记录的最小代价大于最大代价则更新最小代价值
            //
            if (minCost > suf + pre) {
                minCost = suf + pre;
                res = i;
            }
            if (i < n && customers.charAt(i) == 'N') {
                pre++;
            } else if (i < n) {
                suf--;
            }
        }
        return res;
    }

}
