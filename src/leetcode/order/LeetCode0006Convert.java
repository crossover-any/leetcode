package leetcode.order;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0006Convert {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : charArray) {
            rows.get(i).append(c);
            if (i == numRows - 1 || i == 0) {
                flag = -flag;
            }
            i += flag;
        }
        return String.join("", rows);
    }
}
