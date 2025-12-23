/**
 * @author sichu huang
 * @since 2025/12/23 15:51
 */
public class Solution {
    public int smallestEqual(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == (i % 10)) {
                return i;
            }
        }
        return -1;
    }
}
