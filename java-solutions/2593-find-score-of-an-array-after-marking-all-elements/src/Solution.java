import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2024/12/13 17:32
 */
public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }
        Arrays.sort(dp, Comparator.comparingInt(o -> o[0]));
        boolean[] marked = new boolean[n];
        long res = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];
            if (!marked[ind]) {
                res += val;

                marked[ind] = true;
                if (ind > 0) {
                    marked[ind - 1] = true;
                }
                if (ind < n - 1) {
                    marked[ind + 1] = true;
                }
            }
        }
        return res;
    }
}
