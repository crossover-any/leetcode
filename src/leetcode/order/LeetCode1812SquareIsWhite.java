package leetcode.order;

/**
 * @author tengxq
 */
public class LeetCode1812SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '0') )% 2 == 0;
    }
}
