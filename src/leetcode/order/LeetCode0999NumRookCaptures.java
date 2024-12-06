package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode0999NumRookCaptures {

    /**
     * 模拟搜索
     * 1.找到车的位置
     * 2.向四周搜索
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        int cnt = 0;
        int a = 0, b = 0;
        // 找到R的位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        // 向左搜索
        for (int i = b -1; i >= 0; i--) {
            if (board[a][i] == 'p') {
                cnt++;
                break;
            }
            if (board[a][i] == 'B') {
                break;
            }
        }
        // 向右搜索
        for (int i = b + 1; i < board[a].length; i++) {
            if (board[a][i] == 'p') {
                cnt++;
                break;
            }
            if (board[a][i] == 'B') {
                break;
            }
        }
        // 向上搜索
        for (int i = a - 1; i >= 0; i--) {
            if (board[i][b] == 'p') {
                cnt++;
                break;
            }
            if (board[i][b] == 'B') {
                break;
            }
        }
        // 向下搜索
        for (int i = a + 1; i < board.length; i++) {
            if (board[i][b] == 'p') {
                cnt++;
                break;
            }
            if (board[i][b] == 'B') {
                break;
            }
        }
        return cnt;
    }

    public int numRookCaptures2(char[][] board) {
        int cnt = 0;
        int a = 0, b = 0;
        // 找到R的位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        // 优化搜索片段代码 减少重复代码 左 右 上 下
        int[][] directs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direct : directs) {
            for (int i = 1; i < board.length; i++) {
                int x = a + i * direct[0];
                int y = b + i * direct[1];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    break;
                }
                if (board[x][y] == 'B') {
                    break;
                }
                if (board[x][y] == 'p'){}
            }
        }
        return cnt;
    }
}
