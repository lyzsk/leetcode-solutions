/**
 * @author sichu huang
 * @since 2025/12/06 22:13
 */
public class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }
}
