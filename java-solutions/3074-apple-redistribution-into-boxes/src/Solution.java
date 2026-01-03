import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/12/24 17:47
 */
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        int[] fq = new int[51];
        int high = 0, low = 51;
        for (int c : capacity) {
            fq[c]++;
            high = Math.max(high, c);
            low = Math.min(low, c);
        }
        int res = 0;
        for (int i = high; i >= low && sum > 0; i--) {
            while (fq[i]-- > 0 && sum > 0) {
                sum -= i;
                res++;
            }
        }
        return res;
    }
}
