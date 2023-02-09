/**
 * @Classname solveSudoku37
 * @Description TODO
 * @Date 2019/11/11 19:34
 * @Created by Tengxq
 */
public class solveSudoku37 {

    // box size
    int n = 3;
    // row size
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
    /*
    Check if one could place a number d in (row, col) cell
    */
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
        int idx = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
    /*
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) {
                backtrack(row + 1, 0);
            }
            // go to the next column
            else {
                backtrack(row, col + 1);
            }
        }
    }

    public void backtrack(int row, int col) {
    /*
    Backtracking
    */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public static void main(String[] args) {
        solveSudoku37 test = new solveSudoku37();
        char[][] board = new char[9][9];
        char[] row0 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row1 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        board[0] = row0;
        board[1] = row1;
        board[2] = row2;
        board[3] = row3;
        board[4] = row4;
        board[5] = row5;
        board[6] = row6;
        board[7] = row7;
        board[8] = row8;
        test.solveSudoku(board);
        return;
    }
}
