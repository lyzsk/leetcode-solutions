/**
 * @author sichu huang
 * @since 2025/03/18 18:43
 */
public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, maxLength = 1, left = 0, usedBits = 0;
        for (int right = 0; right < n; right++) {
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left];
                left++;
            }
            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
