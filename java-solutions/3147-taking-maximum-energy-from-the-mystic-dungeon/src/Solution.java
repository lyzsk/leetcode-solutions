/**
 * @author sichu huang
 * @since 2025/10/11 07:36
 */
public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int res = Integer.MIN_VALUE;
        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
