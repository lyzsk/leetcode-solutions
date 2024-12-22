/**
 * @author sichu huang
 * @since 2024/12/16 17:36
 */
public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int m = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[m]) {
                    m = j;
                }
            }
            nums[m] *= multiplier;
        }
        return nums;
    }
}
