import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2024/10/30 19:00
 */
public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] pre = getLISArray(nums);
        int[] reversed = reverse(nums);
        int[] suf = getLISArray(reversed);
        suf = reverse(suf);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (pre[i] > 1 && suf[i] > 1) {
                res = Math.max(res, pre[i] + suf[i] - 1);
            }
        }

        return n - res;
    }

    public int[] getLISArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        List<Integer> seq = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int index = binarySearch(seq, nums[i]);
            if (index == seq.size()) {
                seq.add(nums[i]);
                dp[i] = seq.size();
            } else {
                seq.set(index, nums[i]);
                dp[i] = index + 1;
            }
        }
        return dp;
    }

    private int[] reverse(int[] nums) {
        int n = nums.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        return reversed;
    }

    private int binarySearch(List<Integer> seq, int target) {
        int low = 0, high = seq.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (seq.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
