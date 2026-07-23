/**
 *
 * @author sichu huang
 * @since 2026/07/23
 */
public class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int nextPowerOfTwo = 1;
        while (nextPowerOfTwo <= n) {
            nextPowerOfTwo <<= 1;
        }

        return nextPowerOfTwo;
    }
}
