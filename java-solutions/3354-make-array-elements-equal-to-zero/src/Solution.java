/**
 * @author sichu huang
 * @since 2025/10/28 15:52
 */
public class Solution {
    public int countValidSelections(int[] nums) {
        int prefix = 0, cnt = 0, sum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int x : nums) {
            prefix += x;
            if (x == 0) {
                final int move = Math.max(2 - Math.abs(2 * prefix - sum), 0);
                cnt += move;
            }
        }
        return cnt;
    }
}
