/**
 * @author sichu
 * @date 2022/09/29
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);
        }
        return res;
        //        int res = 0;
        //        int[] dp = new int[prices.length];
        //        dp[0] = prices[0];
        //        for (int i = 1; i < prices.length; i++) {
        //            dp[i] = Math.min(prices[i], dp[i - 1]);
        //            res = Math.max(res, prices[i] - dp[i]);
        //        }
        //        return res;
    }
}
