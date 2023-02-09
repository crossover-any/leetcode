/**
 * @Classname climbStairs70
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * @Date 2019/11/14 21:48
 * @Created by Tengxq
 */
public class climbStairs70 {

    public int climbStairs(int n) {
        return climbStatirsByDP(n);
    }

    private int climbStairsN(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsN(n - 1) + climbStairsN(n - 2);
    }

    private int climbStatirsByDP(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        climbStairs70 test = new climbStairs70();
        int i = test.climbStairs(44);
        System.out.println(i);
    }
}
