package leetcode.order;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tengxq
 */
public class LeetCode0406ReconstructQueue {

    public static void main(String[] args) {
        LeetCode0406ReconstructQueue solution = new LeetCode0406ReconstructQueue();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = solution.reconstructQueue(people);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        // 排序前 {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // 排序后 {{7, 0}, {7, 1}, {6, 1}, {5, 0}, {5, 2}, {4, 4}}
        List<int[]> result = new LinkedList<>();
        // 按人的k值插入, 这样能保证身高的相对顺序不被打乱
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}
