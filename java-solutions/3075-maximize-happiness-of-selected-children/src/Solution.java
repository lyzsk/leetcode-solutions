import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/05/10
 **/
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length;
        int j = 0;
        for (int i = n - 1; i >= n - k; i--) {
            happiness[i] = Math.max(happiness[i] - j++, 0);
            res += happiness[i];
        }
        return res;
    }
}
