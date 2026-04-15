/**
 *
 * @author sichu huang
 * @since 2026/04/08 19:57
 */
public class Solution {

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] t : queries) {
            int l = t[0];
            int r = t[1];
            int k = t[2];
            int v = t[3];

            int idx = l;

            while (idx <= r) {
                long temp = nums[idx];
                int MOD = (int)1e9 + 7;
                nums[idx] = (int)((temp * v) % MOD);
                idx += k;
            }
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
