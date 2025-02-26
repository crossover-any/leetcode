package leetcode.order;

import java.util.*;

public class LeetCode1146SnapshotArray {

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(2);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(0,4);
        snapshotArray.snap();
        snapshotArray.get(0, 1);

    }

   static class SnapshotArray {

        private int[] mem;

        private int snapNo;

        private Map<Integer, List<int[]>> snapMap = new HashMap<>();

        private List<int[]> changes = new ArrayList<>();

        public SnapshotArray(int length) {
            mem = new int[length];
            snapNo = 0;
        }

        public void set(int index, int val) {
            changes.add(new int[]{index, val});
        }

        public int snap() {
            for (int[] pairs : changes) {
                snapMap.computeIfAbsent(pairs[0], k -> {
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{0, mem[pairs[0]]});
                    return list;
                }).add(new int[]{snapNo, pairs[1]});
                mem[pairs[0]] = pairs[1];
            }
            changes.clear();
            return snapNo++;
        }

        public int get(int index, int snap_id) {
            List<int[]> snapshots = snapMap.get(index);
            if (snapshots == null) {
                return mem[index];
            }
            // 查找小于并且最接近snap_id的值
            int left = 0;
            int right = snapshots.size() - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int[] pairs = snapshots.get(mid);
                if (pairs[0] <= snap_id) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == snapshots.size() || snapshots.get(left)[0] > snap_id ) {
                return snapshots.get(left - 1)[1];
            }
            return snapshots.get(left)[1];
        }
    }
}
