import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/10/10
 */
public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long)k1 + k2;
        int n = nums1.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            sum += nums1[i];
        }
        if (sum <= k) {
            return 0;
        }

        Arrays.sort(nums1);
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            d[i] = nums1[n - 1 - i];
        }

        for (int i = 1; i <= n; i++) {
            long cost = (long)(d[i - 1] - d[i]) * i;
            if (cost > k) {
                long q = k / i, r = k % i, hi = d[i - 1] - q;
                long ans = hi * hi * (i - r) + (hi - 1) * (hi - 1) * r;
                for (int j = i; j < n; j++) {
                    ans += (long)d[j] * d[j];
                }
                return ans;
            }
            k -= cost;
        }
        return 0;
    }
}
