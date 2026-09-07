import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/09/07
 */
public class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int distinctSubseqII(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1) {
                res = (res + f[last[i]]) % MOD;
            }
        }
        return res;
    }
}
