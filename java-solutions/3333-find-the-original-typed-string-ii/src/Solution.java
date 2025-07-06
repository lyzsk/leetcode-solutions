import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/07/03 01:25
 */
public class Solution {

    private static final int mod = (int)(1e9 + 7);

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        int cnt = 1;
        List<Integer> freq = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++cnt;
            } else {
                freq.add(cnt);
                cnt = 1;
            }
        }
        freq.add(cnt);
        long res = 1;
        for (int o : freq) {
            res = res * o % mod;
        }
        if (freq.size() >= k) {
            return (int)res;
        }
        int[] f = new int[k];
        int[] g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);
        for (Integer integer : freq) {
            int[] f_new = new int[k];
            for (int j = 1; j < k; ++j) {
                f_new[j] = g[j - 1];
                if (j - integer - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - integer - 1] + mod) % mod;
                }
            }
            int[] g_new = new int[k];
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
            }
            f = f_new;
            g = g_new;
        }
        return (int)((res - g[k - 1] + mod) % mod);
    }
}
