import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/11/17
 */
public class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        List<Integer>[] factors = new ArrayList[n + 1];
        Arrays.setAll(factors, x -> new ArrayList<>());
        // 预处理每个数的真因子
        for (int d = 1; d <= n / 2; d++) {
            for (int m = d * 2; m <= n; m += d) {
                factors[m].add(d);
            }
        }
        int[][] cost = new int[n][n];
        for (int l = 0; l + 1 < n; l++) {
            for (int r = l + 1; r < n; r++) { // 子串长度至少为 2
                cost[l][r] = segmentCost(ch, l, r - l + 1, factors);
            }
        }
        int[][] memo = new int[k + 1][n];
        for (int seg = 0; seg <= k; seg++) {
            Arrays.fill(memo[seg], -1);
        }
        return solve(k, 0, n, cost, memo);
    }

    private int segmentCost(char[] s, int l, int m, List<Integer>[] factors) {
        int best = m;
        for (int d : factors[m]) {
            int groups = m / d; // 每组有 groups 个字符
            int changes = 0;
            for (int offset = 0; offset < d; offset++) {
                for (int t = 0; t < groups / 2; t++) { // 组内首尾配对
                    if (s[l + offset + t * d] != s[l + offset
                        + (groups - 1 - t) * d]) {
                        changes++;
                    }
                }
            }
            best = Math.min(best, changes);
        }
        return best;
    }

    private int solve(int seg, int start, int n, int[][] cost, int[][] memo) {
        if (seg == 1) { // 只剩一段
            return cost[start][n - 1];
        }
        if (memo[seg][start] != -1) { // 之前算过
            return memo[seg][start];
        }
        int best = n;
        int limit = n - 1 - 2 * (seg - 1); // 第一段之后还要留出 seg-1 段
        for (int e = start + 1; e <= limit; e++) {
            best = Math.min(best,
                cost[start][e] + solve(seg - 1, e + 1, n, cost, memo));
        }
        memo[seg][start] = best;
        return best;
    }
}
