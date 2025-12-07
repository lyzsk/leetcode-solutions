/**
 * @author sichu huang
 * @since 2025/11/29 20:31
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
