package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0661ImageSmoother {

    public static void main(String[] args) {
        new LeetCode0661ImageSmoother().imageSmoother2(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = getAvg(img, i, j);
            }
        }

        return res;
    }

    private int getAvg(int[][] img, int i, int j) {
        int sum = 0;
        int count = 0;
        for (int r = i - 1, countRow = r + 3; r < img.length && r < countRow; r++) {
            if (r < 0) {
                continue;
            }
            for (int k = j-1, countCol = k + 3; k < img[0].length && countCol > k ; k++) {
                if (k < 0) {
                    continue;
                }
                sum += img[r][k];
                count++;
            }
        }
        return sum/count;
    }


    public int[][] imageSmoother2(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] sums = new int[row + 1][col + 1];
        // 遍历图像矩阵获得二维前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + img[i][j];
            }
        }
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(row - 1 , i + 1), d = Math.min(col - 1, j + 1);
                int count = (c - a + 1) * (d - b + 1);
                int sum = sums[c + 1][d + 1] - sums[c + 1][b] - sums[a][d + 1] + sums[a][b];
                res[i][j] = sum / count;
            }
        }

        return res;
    }
}
