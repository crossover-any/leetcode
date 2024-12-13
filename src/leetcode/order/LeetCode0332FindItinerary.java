package leetcode.order;

import java.util.*;

/**
 * @author tengxq
 */
public class LeetCode0332FindItinerary {

    private LinkedList<String> path = new LinkedList<>();

    private boolean[] visited = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        visited = new boolean[tickets.size()];
        // 先对tickets进行排序减少递归次数
        tickets.sort(Comparator.comparing(o -> o.get(1)));
        backtrace(tickets);
        path.add("JFK");
        return path;
    }

    public boolean backtrace(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (visited[i]) {
                continue;
            }
            List<String> ticket = tickets.get(i);
            if (path.getLast().equals(ticket.get(0))) {
                visited[i] = true;
                path.add(ticket.get(1));
                if (backtrace(tickets)) {
                    return true;
                }
                path.removeLast();
                visited[i] = false;
            }
        }
        return false;
    }
}
