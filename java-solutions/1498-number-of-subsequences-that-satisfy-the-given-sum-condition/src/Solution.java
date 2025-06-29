import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/06/30 01:16
 */
public class Solution {
    private static final int P = (int)(1e9 + 7);
    private static final int MAX_N = 100005;
    private int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
        pretreatment();
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length && nums[i] * 2 <= target; ++i) {
            int maxValue = target - nums[i];
            int pos = binarySearch(nums, maxValue) - 1;
            int contribute = (pos >= i) ? f[pos - i] : 0;
            res = (res + contribute) % P;
        }

        return res;
    }

    private void pretreatment() {
        f[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] << 1) % P;
        }
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (mid == nums.length) {
                return mid;
            }
            int num = nums[mid];
            if (num <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
