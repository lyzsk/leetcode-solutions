import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/10/04
 **/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length >> 1);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, -prices[0]);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
