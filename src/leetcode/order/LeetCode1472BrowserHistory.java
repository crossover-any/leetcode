package leetcode.order;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1472BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google");
        browserHistory.visit("facebook");
        browserHistory.visit("youtube");
        browserHistory.back(1);
        browserHistory.back(1);
        browserHistory.forward(1);
        browserHistory.visit("linkedin");
        browserHistory.forward(2);
        browserHistory.back(2);
        browserHistory.back(2);

    }



    static class BrowserHistory {

        private List<String> mem = new ArrayList<>();
        private int position;

        public BrowserHistory(String homepage) {
            mem.add(homepage);
            position = 0;
        }

        public void visit(String url) {
            while (position != mem.size() - 1) {
                mem.remove(mem.size() - 1);
            }
            mem.add(url);
            position++;
        }

        public String back(int steps) {
            position = steps >= position? 0: position - steps;
            return mem.get(position);
        }

        public String forward(int steps) {
            position = position + steps;
            if (position >= mem.size()) {
                position = mem.size() - 1;
            }
            return mem.get(position);
        }
    }
}
