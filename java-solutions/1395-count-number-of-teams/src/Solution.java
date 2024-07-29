/**
 * @author sichu huang
 * @date 2024/07/29
 **/
public class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int jless = 0;
            int jmore = 0;
            int kless = 0;
            int kmore = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    ++jless;
                } else if (rating[j] > rating[i]) {
                    ++jmore;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[k] < rating[i]) {
                    ++kless;
                } else if (rating[k] > rating[i]) {
                    ++kmore;
                }
            }
            res += jless * kmore + jmore * kless;
        }
        return res;
    }
}
