package leetcode.order;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0695MaxAreaOfIsland {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans,bfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = 0;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans += size;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int curX = poll[0];
                int curY = poll[1];
                for (int[] d : dir) {
                    int nextX = curX + d[0];
                    int nextY = curY + d[1];
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 0) {
                        continue;
                    }
                    grid[nextX][nextY] = 0;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return ans;
    }
}
