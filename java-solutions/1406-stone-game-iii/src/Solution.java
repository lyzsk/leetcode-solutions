import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/08/03
 */
public class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            int pre = 0;
            for (int j = i + 1; j <= i + 3 && j <= n; ++j) {
                pre += stoneValue[j - 1];
                f[i] = Math.max(f[i], pre - f[j]);
            }
        }
        if (f[0] == 0) {
            return "Tie";
        } else {
            return f[0] > 0 ? "Alice" : "Bob";
        }
    }
}
