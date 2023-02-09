package niuke;

/**
 * @Classname RobotMoving
 * @Description TODO
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * @Date 2020/1/5 10:34
 * @Created by Tengxq
 */
public class RobotMoving {
    private int[] rowDirect = {-1, 0, 1, 0};
    private int[] colDirect = {0, 1, 0, -1};

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        boolean[][] mark = new boolean[rows + 1][cols + 1];
        return moving(threshold, mark, rows, cols, 0, 0);
    }

    public int moving(int threshold, boolean[][] mark, int rows, int cols, int i, int j) {
        int arrivedCount = 0;
        if (i < 0 || i > rows || j < 0 || j > cols) {
            return arrivedCount;
        }
        if (mark[i][j]) {
            return arrivedCount;
        }
        if (isNotAllowedEntrant(threshold, i, j)) {
            return arrivedCount;
        }
        mark[i][j] = true;
        for (int m = 0; m < 4; m++) {
            arrivedCount += moving(threshold, mark, rows, cols, i + rowDirect[m], j + colDirect[m]);
        }
        return arrivedCount + 1;
    }

    public boolean isNotAllowedEntrant(int threshold, int i, int j) {
        int sum = 0;
        while (i >= 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j >= 0) {
            sum += j % 10;
            j /= 10;
        }
        return threshold < sum;
    }

    public static void main(String[] args) {
        RobotMoving test = new RobotMoving();
        System.out.println(test.movingCount(5, 10, 10));
    }
}
