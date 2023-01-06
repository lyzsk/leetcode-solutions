import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if (costs == null || costs.length == 0 || coins == 0) {
            return 0;
        }
        Arrays.sort(costs);
        if (coins < costs[0]) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            int cost = costs[i];
            if (coins >= cost) {
                coins -= costs[i];
                ++res;
            } else {
                break;
            }
        }
        return res;
    }
}
