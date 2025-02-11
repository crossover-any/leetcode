package leetcode.order;

import java.util.LinkedList;

public class LeetCode0071SimplifyPath {

    public static void main(String[] args) {
        LeetCode0071SimplifyPath leetCode0071SimplifyPath = new LeetCode0071SimplifyPath();
        String s = leetCode0071SimplifyPath.simplifyPath("/.../a/../b/c/../d/./");
        System.out.print(s);
    }

    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        String[] names = path.split("/");
        for (String name : names) {
            if (".".equals(name) || "".equals(name)) {
                continue;
            }
            if ("..".equals(name)) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else {
                queue.addLast(name);
            }
        }
        return "/" + String.join("/", queue);
    }
}
