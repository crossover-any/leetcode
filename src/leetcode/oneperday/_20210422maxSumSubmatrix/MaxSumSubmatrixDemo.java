package leetcode.oneperday._20210422maxSumSubmatrix;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * 分解问题：
 * 1.一个位置不超过K的矩形区域有多少种情况？
 * (1) 以该点为顶点向右扩展的行 1* M(M<=k)
 * (2) 以该点为顶点向下扩展的列 1*N(N<=k)
 * (3) 以该点为顶点的k*k矩阵
 * 2.怎么求得矩形区域和的最大值
 * （1）因为列和行都是连续的，所以直接遍历即可
 * （2）矩形有 M*N(M<=k,N<=k)
 * <p>
 * 方法一
 * 执行用时：651 ms, 在所有 Java 提交中击败了16.53%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了75.29%的用户
 *
 * @author: tengxq
 * @since: 2021/4/22 8:59
 */
public class MaxSumSubmatrixDemo {
    public static void main(String[] args) {
        int[][] arr = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        Solution solution = new Solution();
        System.out.println(solution.maxSumSubmatrix2(arr, 3));

    }
}


class Solution {
    private int[][] calMatrix = null;

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        calMatrix = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < matrix[i][j] && matrix[i][j] <= k) {
                    max = matrix[i][j];
                }
                int num = findMaxInMatrix1(matrix, i, j, k);
                if (num > max) {
                    max = num;
                }
                if (max == k) {
                    return max;
                }
            }
        }

        return max;
    }

    private int findMaxInMatrix1(int[][] matrix, int i, int j, int k) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        for (int p = 0; i + p < m; p++) {
            for (int q = 0; q + j < n; q++) {
                calMatrix[p][q] = matrix[p + i][q + j];
                if (q > 0) {
                    calMatrix[p][q] += calMatrix[p][q - 1];
                }
                if (p > 0) {
                    calMatrix[p][q] += calMatrix[p - 1][q];
                }
                if (q > 0 && p > 0) {
                    calMatrix[p][q] -= calMatrix[p - 1][q - 1];
                }
                if (calMatrix[p][q] <= k && max < calMatrix[p][q]) {
                    max = calMatrix[p][q];
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        initCalArr(matrix, m, n);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = findMaxInMatrix2(matrix, i, j, k);
                if (num > max) {
                    max = num;
                    if (max == k) {
                        return max;
                    }
                }
            }
        }
        return max;
    }

    private int findMaxInMatrix2(int[][] matrix, int i, int j, int k) {
        int max = Integer.MIN_VALUE;
        int m = calMatrix.length;//row
        int n = calMatrix[0].length;//col
        for (int p = i + 1; p < m; p++) {
            for (int q = j + 1; q < n; q++) {
                int cal = calMatrix[p][q] - calMatrix[i + 1][j + 1] + matrix[i][j] - calMatrix[p - 1][q] - calMatrix[p][j];
                if (cal > max && cal <= k) {
                    max = cal;
                }
            }
        }
        return max;
    }

    private void initCalArr(int[][] matrix, int m, int n) {
        calMatrix = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                calMatrix[i][j] = matrix[i - 1][j - 1] + calMatrix[i - 1][j] + calMatrix[i][j - 1] - calMatrix[i - 1][j - 1];
            }
        }
    }
}
