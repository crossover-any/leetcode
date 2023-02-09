/**
 * @Classname Fib509
 * @Description TODO
 * @Date 2019/11/14 22:58
 * @Created by Tengxq
 */
public class Fib509 {
    private int[] nums;

    public int fib(int N) {
        if (N == 1 || N == 0) {
            return N;
        }
        nums = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            nums[i] = -1;
        }
        nums[0] = 0;
        nums[1] = 1;
        return recursion(N);
    }

    public int recursion(int n) {
        if (nums[n] != -1) {
            return nums[n];
        }
        nums[n] = recursion(n - 2) + recursion(n - 1);
        return nums[n];

    }

    public static void main(String[] args) {
        Fib509 test = new Fib509();
        int fib = test.fib(2);
        System.out.println(fib);

    }
}
