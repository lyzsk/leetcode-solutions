import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/10/22 20:25
 */
public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int m = numOperations;
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, check(nums, nums[i], k, m));
            res = Math.max(res, check(nums, nums[i] - k, k, m));
            res = Math.max(res, check(nums, nums[i] + k, k, m));
        }
        return res;
    }

    private int check(int[] nums, int n, int t, int m) {
        long nL = n;
        long tL = t;
        int l = lowerBound(nums, nL);
        int h = upperBound(nums, nL);
        int ll = lowerBound(nums, nL - tL);
        int hh = upperBound(nums, nL + tL);
        int res = (hh - h) + (l - ll);
        return Math.min(m, res) + (h - l);
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
