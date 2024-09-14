/**
 * @author sichu huang
 * @date 2024/09/14
 **/
public class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int maxLength = 0;
        int currLength = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num == maxVal) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0;
            }
        }
        return maxLength;
    }
}
