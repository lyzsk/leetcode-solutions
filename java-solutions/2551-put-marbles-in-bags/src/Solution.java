import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/03/31 22:38
 */
public class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSums);
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += pairSums[i];
            maxSum += pairSums[n - i - 2];
        }
        return maxSum - minSum;
    }
}
