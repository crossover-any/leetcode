package leetcode.order;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1656OrderedStream {


    class OrderedStream {

        int ptr;
        String[] strArray;

        public OrderedStream(int n) {
            ptr = 1;
            strArray = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            List<String> res = new ArrayList<>();
            strArray[idKey] = value;
            while (ptr < strArray.length && strArray[ptr] != null) {
                res.add(strArray[ptr++]);
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}
