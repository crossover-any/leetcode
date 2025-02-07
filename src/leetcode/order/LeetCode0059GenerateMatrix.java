package leetcode.order;

public class LeetCode0059GenerateMatrix {

    public static void main(String[] args) {
        LeetCode0059GenerateMatrix generateMatrix = new LeetCode0059GenerateMatrix();
        generateMatrix.generateMatrix(5);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 循环多少圈，循环一次可以填充两行两列,如果n是基数，那么中间值需要填充，偶数则不用
        int loop = n/2;
        // 起始行与起始列
        int rowStart = 0;
        int colStart = n - 1;
        int offset = 1;
        int count = 1;
        while (loop > 0) {
            // 填充东方向从左到右
            for (int i = rowStart; i < n - offset; i++) {
                res[rowStart][i] = count++;
            }

            // 填充南方向从上到下
            for (int i = rowStart; i < n - offset; i++) {
                res[i][colStart] = count++;
            }

            // 填充西方向从右到左
            for (int i = n - offset; i > rowStart; i--) {
                res[n - offset][i] = count++;
            }

            // 填充北方向从下到上
            for (int i = n - offset; i > rowStart ; i--) {
                res[i][offset - 1] = count++;
            }
            loop--;
            offset++;
            rowStart++;
            colStart--;
        }
        if (n % 2 == 1) {
            res[n/2][n/2] = n * n;
        }
        return res;
    }
}
