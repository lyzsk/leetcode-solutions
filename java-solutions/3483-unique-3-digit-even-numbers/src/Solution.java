/**
 *
 * @author sichu huang
 * @since 2026/09/11
 */
public class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] vis = new boolean[1000];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < n; ++k) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }
                    int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (!vis[x]) {
                        vis[x] = true;
                        ++res;
                    }
                }
            }
        }
        return res;
    }
}
