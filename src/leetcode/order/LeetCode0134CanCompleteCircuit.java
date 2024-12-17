package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0134CanCompleteCircuit {

    /**
     * 134. 加油站 整体最优
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 记录当前剩余油量
        int curSum = 0;
        // 记录所需油量的最大值, 等价于记录剩余油量的最小值
        int minGas = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int surplus = gas[i] - cost[i];
            curSum+= surplus;
            minGas = Math.min(minGas, curSum);
        }
        // 油箱剩余油量小于0，无法完成
        if (curSum < 0) {
            return -1;
        }
        // 从0开始每个位置都有剩余油量，则0为起始点
        if (minGas >= 0) {
            return 0;
        }
        // 这里可以理解为从某个位置出发能够覆盖油量消耗最大的地方的第一个位置，那么从该位置开始，能够覆盖所有位置的最小值就是起始点
        for (int i = gas.length - 1; i >= 0; i--) {
            int surplus = gas[i] - cost[i];
            minGas += surplus;
            if (minGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 贪心
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }
}
