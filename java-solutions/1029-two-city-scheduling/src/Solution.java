import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/12/03
 **/
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[] diff = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = costs[i][1] - costs[i][0];
            res += costs[i][0];
        }
        Arrays.sort(diff);
        for (int i = 0; i < n >> 1; i++) {
            res += diff[i];
        }
        return res;
    }
}
