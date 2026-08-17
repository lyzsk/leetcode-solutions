/**
 *
 * @author sichu huang
 * @since 2026/08/17
 */
public class Solution {
    private int[][] f;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        f = new int[n][n];
        return dfs(stoneValue, 0, n - 1);
    }

    private int dfs(int[] stoneValue, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (f[left][right] != 0) {
            return f[left][right];
        }

        int sum = 0;
        for (int i = left; i <= right; ++i) {
            sum += stoneValue[i];
        }
        int suml = 0;
        for (int i = left; i < right; ++i) {
            suml += stoneValue[i];
            int sumr = sum - suml;
            if (suml < sumr) {
                f[left][right] =
                    Math.max(f[left][right], dfs(stoneValue, left, i) + suml);
            } else if (suml > sumr) {
                f[left][right] = Math.max(f[left][right],
                    dfs(stoneValue, i + 1, right) + sumr);
            } else {
                f[left][right] = Math.max(f[left][right],
                    Math.max(dfs(stoneValue, left, i),
                        dfs(stoneValue, i + 1, right)) + suml);
            }
        }
        return f[left][right];
    }
}
