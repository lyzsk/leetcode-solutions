/**
 * @author sichu huang
 * @date 2024/04/29
 **/
public class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            k ^= num;
        }
        return Integer.bitCount(k);
    }
}
