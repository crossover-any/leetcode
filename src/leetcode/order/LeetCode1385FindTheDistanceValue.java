package leetcode.order;

import java.util.Arrays;

public class LeetCode1385FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            // 寻找介于 i -d, i + d的数
            // 寻找等于或第一个大于arr[i] - d的坐标
            int left = searchLower(arr2, arr1[i] - d);
            if (Math.abs(arr2[left] - arr1[i]) <= d) {
                continue;
            }

            // 寻找右边等于或第一个小于arr[i] + d的数坐标
            int right = searchHigher(arr2, arr1[i] + d);
            if (Math.abs(arr2[right] - arr1[i]) <= d) {
                continue;
            }
            res++;
        }
        return res;
    }

    private int searchLower(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                // 如果找不到target，会返回大于该数的坐标
                left = mid + 1;
            }
        }
        return left == arr.length? left - 1: left;
    }

    private int searchHigher(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == arr.length? left - 1: left;
    }

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int x : arr1) {
            int i = Arrays.binarySearch(arr2, x - d);
            if (i < 0) {
                // 如果没找到会返回-left 也就说假设数组nums长度为10
                // 如果 nums[5]< target < nums[6] 会返回 -6
                // 如果 target < nums[0] 会返回 -1
                // 如果 target > nums[9] 会返回 -11
                i = ~i; // -i - 1
            }
            if (i == arr2.length || arr2[i] > x + d) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = Arrays.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11}, 10);
        System.out.println(i);
    }

}
