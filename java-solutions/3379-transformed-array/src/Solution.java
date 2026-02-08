/**
 * @author sichu huang
 * @since 2026/02/05 17:08
 */
public class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[((i + nums[i]) % n + n) % n];
        }
        return res;
    }
}
