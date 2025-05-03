/**
 * @author sichu huang
 * @since 2025/04/30 15:50
 */
public class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ++res;
            }
        }
        return res;
    }
}
