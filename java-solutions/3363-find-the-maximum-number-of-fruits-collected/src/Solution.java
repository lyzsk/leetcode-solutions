/**
 * @author sichu huang
 * @since 2025/08/08 00:20
 */
public class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += fruits[i][i];
        }

        java.util.function.Supplier<Integer> dp = () -> {
            int[] prev = new int[n];
            int[] curr = new int[n];
            java.util.Arrays.fill(prev, Integer.MIN_VALUE);
            java.util.Arrays.fill(curr, Integer.MIN_VALUE);
            prev[n - 1] = fruits[0][n - 1];
            for (int i = 1; i < n - 1; ++i) {
                for (int j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                    int best = prev[j];
                    if (j - 1 >= 0) {
                        best = Math.max(best, prev[j - 1]);
                    }
                    if (j + 1 < n) {
                        best = Math.max(best, prev[j + 1]);
                    }
                    curr[j] = best + fruits[i][j];
                }
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }
            return prev[n - 1];
        };

        res += dp.get();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }

        res += dp.get();
        return res;
    }
}
