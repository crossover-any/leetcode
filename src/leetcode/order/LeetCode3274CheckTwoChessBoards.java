package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode3274CheckTwoChessBoards {

    public static void main(String[] args) {
        LeetCode3274CheckTwoChessBoards test = new LeetCode3274CheckTwoChessBoards();
        System.out.println(test.checkTwoChessboards("a1", "b1"));
    }

    private static final int[] chessboards = new int[]{0b10101010, 0b01010101};

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int chessboard = (chessboards[(coordinate1.charAt(0) - 'a')%2]<<(coordinate1.charAt(1) - '1')) & 0b10000000 ^ (chessboards[(coordinate2.charAt(0) - 'a')%2]<<(coordinate2.charAt(1) - '1')) & 0b10000000;
        return chessboard == 0;
    }
}
