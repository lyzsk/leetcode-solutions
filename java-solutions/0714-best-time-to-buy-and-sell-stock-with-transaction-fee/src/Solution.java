/**
 * @author sichu
 * @date 2023/10/06
 **/
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
