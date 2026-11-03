/**
 *
 * @author sichu huang
 * @since 2026/11/03
 */
public class Solution {
    public int minMoves(int[] nums) {
        int mx = nums[0];
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int res = 0;
        for (int x : nums) {
            res += mx - x;
        }
        return res;
    }
}
