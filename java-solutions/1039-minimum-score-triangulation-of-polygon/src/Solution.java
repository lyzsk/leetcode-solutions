import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/09/29 19:50
 */
public class Solution {
    private final Map<Integer, Integer> memo = new HashMap<>();
    private int n;
    private int[] values;

    public int minScoreTriangulation(int[] values) {
        this.n = values.length;
        this.values = values;
        return dp(0, n - 1);
    }

    private int dp(int i, int j) {
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[j];
        }
        int key = i * n + j;
        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                minScore =
                    Math.min(minScore, values[i] * values[k] * values[j] + dp(i, k) + dp(k, j));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }
}
