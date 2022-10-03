/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                res += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return res;
    }
}
