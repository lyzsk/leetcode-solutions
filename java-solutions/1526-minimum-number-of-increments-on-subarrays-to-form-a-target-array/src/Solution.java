/**
 * @author sichu huang
 * @since 2025/10/30 23:08
 */
public class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int res = target[0];
        for (int i = 1; i < n; ++i) {
            res += Math.max(target[i] - target[i - 1], 0);
        }
        return res;
    }
}
