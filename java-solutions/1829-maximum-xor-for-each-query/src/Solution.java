/**
 * @author sichu huang
 * @since 2024/11/08 16:14
 */
public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxNum = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] res = new int[n];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            res[i] = xor ^ maxNum;
            xor ^= nums[j];
        }
        return res;
    }
}
