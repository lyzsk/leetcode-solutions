/**
 *
 * @author sichu huang
 * @since 2026/11/11
 */
public class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1,
        int need2) {
        long totalCost;

        if (cost1 + cost2 <= costBoth) {
            totalCost = (long)cost1 * need1 + (long)cost2 * need2;
        } else {
            int cnt_3 = Math.min(need1, need2);
            totalCost = (long)cnt_3 * costBoth;
            need1 -= cnt_3;
            need2 -= cnt_3;
            if (need1 > 0) {
                totalCost += (long)need1 * Math.min(cost1, costBoth);
            } else if (need2 > 0) {
                totalCost += (long)need2 * Math.min(cost2, costBoth);
            }
        }

        return totalCost;
    }
}
