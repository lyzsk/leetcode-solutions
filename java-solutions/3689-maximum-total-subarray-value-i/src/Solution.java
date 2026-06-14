/**
 *
 * @author sichu huang
 * @since 2026/06/09 18:25
 */
public class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long)(m2 - m1) * k;
    }
}
