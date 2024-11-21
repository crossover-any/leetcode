package leetcode;

import java.util.Arrays;

/**
 * @author tengxq
 */
public class LeetCode2410MatchPlayersAndTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;
        int pIndex = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        // 根据训练师的能力，找到能和每个运动员配对的最小能力值
        for (int i = 0; i < trainers.length && pIndex < players.length; i++) {
            if (trainers[i] >= players[pIndex]) {
                ans++;
                pIndex++;
            }

        }
        return ans;
    }
}
