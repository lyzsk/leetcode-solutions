import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/12/02
 **/
public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int res = 0;
        // dp[i][j] = arr[i] arr[j] 为后缀的斐波那契序列, i > j
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > res; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    break;
                }
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k == -1) {
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][k] + 1);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
