package leetcode.order;

public class LeetCode1287FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int num = arr[0];
        int count = 1;
        int maxCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                    num = arr[i];
                }
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
            if (4*count > n) {
                break;
            }
        }
        return num;
    }

    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        for (int i = 0; i < n; i += span) {
            int start = binarySearch(arr, arr[i]);
            int end = binarySearch(arr, arr[i] + 1);
            if (end - start >= span) {
                return arr[i];
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }


}
