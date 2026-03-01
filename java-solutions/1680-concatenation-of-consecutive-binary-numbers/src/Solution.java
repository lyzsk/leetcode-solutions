/**
 * @author sichu huang
 * @since 2026/02/28 18:23
 */
public class Solution {

    private static final int MOD = (int)(1e9 + 7);

    public int concatenatedBinary(int n) {
        int res = 0, shift = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            res = (int)((((long)res << shift) + i) % MOD);
        }
        return res;
    }
}
