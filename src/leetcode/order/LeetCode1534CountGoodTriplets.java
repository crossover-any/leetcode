package leetcode.order;

public class LeetCode1534CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int mx = 0;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }
        int[] s = new int[mx + 2]; // cnt 数组的前缀和

        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            int y = arr[j];
            for (int k = j + 1; k < arr.length; k++) {
                int z = arr[k];
                if (Math.abs(y - z) > b) {
                    continue;
                }
                int l = Math.max(Math.max(y - a, z - c), 0);
                int r = Math.min(Math.min(y + a, z + c), mx);
                ans += Math.max(s[r + 1] - s[l], 0); // 如果 l > r + 1，s[r + 1] - s[l] 可能是负数
            }
            for (int v = y + 1; v < s.length; v++) {
                s[v]++; // 把 y 加到 cnt 数组中，更新所有受到影响的前缀和
            }
        }
        return ans;
    }
}
