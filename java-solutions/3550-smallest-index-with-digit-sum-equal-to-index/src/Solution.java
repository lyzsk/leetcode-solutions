/**
 *
 * @author sichu huang
 * @since 2026/09/24
 */
public class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitSum = 0;

            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}
