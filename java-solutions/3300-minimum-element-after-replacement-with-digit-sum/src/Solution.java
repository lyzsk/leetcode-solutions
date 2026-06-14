/**
 *
 * @author sichu huang
 * @since 2026/05/29 11:08
 */
public class Solution {
    public int minElement(int[] nums) {
        int res = 37;
        for (int num : nums) {
            int dig = 0;
            while (num > 0) {
                dig += num % 10;
                num /= 10;
            }
            res = Math.min(res, dig);
        }
        return res;
    }
}
