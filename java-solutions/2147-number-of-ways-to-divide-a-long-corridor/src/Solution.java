/**
 * @author sichu huang
 * @since 2025/12/14 10:11
 */
public class Solution {

    private static final int MOD = (int)(1e9 + 7);

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int prev = -1, cnt = 0, res = 1;
        for (int i = 0; i < n; ++i) {
            if (corridor.charAt(i) == 'S') {
                ++cnt;
                if (cnt >= 3 && cnt % 2 == 1) {
                    res = (int)((long)res * (i - prev) % MOD);
                }
                prev = i;
            }
        }
        if (cnt < 2 || cnt % 2 != 0) {
            res = 0;
        }
        return res;
    }
}
