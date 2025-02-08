package leetcode.order;

public class LeetCode0048Rotate {

    public static void main(String[] args) {
        LeetCode0048Rotate leetCode0048Rotate = new LeetCode0048Rotate();
        leetCode0048Rotate.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 交换列位置
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                tmp = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
