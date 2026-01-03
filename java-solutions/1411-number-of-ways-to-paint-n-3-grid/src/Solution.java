import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2026/01/03 18:36
 */
public class Solution {
    private static final int MOD = (int)(1e9 + 7);

    public int numOfWays(int n) {
        List<Integer> types = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (i != j && j != k) {
                        types.add(i * 9 + j * 3 + k);
                    }
                }
            }
        }
        int typeCnt = types.size();
        int[][] related = new int[typeCnt][typeCnt];
        for (int i = 0; i < typeCnt; ++i) {
            int x1 = types.get(i) / 9, x2 = types.get(i) / 3 % 3, x3 = types.get(i) % 3;
            for (int j = 0; j < typeCnt; ++j) {
                int y1 = types.get(j) / 9, y2 = types.get(j) / 3 % 3, y3 = types.get(j) % 3;
                if (x1 != y1 && x2 != y2 && x3 != y3) {
                    related[i][j] = 1;
                }
            }
        }
        int[][] f = new int[n + 1][typeCnt];
        for (int i = 0; i < typeCnt; ++i) {
            f[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < typeCnt; ++j) {
                for (int k = 0; k < typeCnt; ++k) {
                    if (related[k][j] != 0) {
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < typeCnt; ++i) {
            res += f[n][i];
            res %= MOD;
        }
        return res;
    }
}
