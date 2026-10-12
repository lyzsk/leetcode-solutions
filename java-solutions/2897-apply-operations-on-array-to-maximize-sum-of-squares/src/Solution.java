import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/10/12
 */
public class Solution {
    private static final int MOD = (int)(1e9 + 7);

    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[30];
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    cur |= (1L << j);
                    cnt[j]--;
                }
            }
            res = (res + cur * cur) % MOD;
        }
        return (int)res;
    }
}
