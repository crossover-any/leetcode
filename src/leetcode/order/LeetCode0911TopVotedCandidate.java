package leetcode.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0911TopVotedCandidate {

    class TopVotedCandidate {

        private Map<Integer, List<Integer>> voteTimeDic;

        public TopVotedCandidate(int[] persons, int[] times) {
            voteTimeDic = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
                voteTimeDic.computeIfAbsent(persons[i], k -> new ArrayList<>()).add(times[i]);
            }
        }

        public int q(int t) {
            int max = 0;
            int maxIndex = 0;
            int lastVoteTime = 0;
            for (Map.Entry<Integer, List<Integer>> entry : voteTimeDic.entrySet()) {
                List<Integer> votes = entry.getValue();
                // 返回大于等于t的下标
                int i = binarySearch(votes, t);
                if (votes.get(i) > t) {
                    i--;
                }
                int size = i + 1;
                if ((size == max && votes.get(i) > lastVoteTime) || size > max) {
                    // 票数相同,取最后一个获得支持的候选人
                    lastVoteTime = votes.get(i);
                    max = size;
                    maxIndex = entry.getKey();

                }
            }
            return maxIndex;
        }

        private int binarySearch(List<Integer> list, int target) {
            if (target >= list.get(list.size() - 1)) {
                return list.size() - 1;
            }
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (list.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
