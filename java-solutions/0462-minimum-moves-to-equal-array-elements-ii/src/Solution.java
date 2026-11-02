import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/11/02
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, res = 0, x = nums[n / 2];
        for (int num : nums) {
            res += Math.abs(num - x);
        }
        return res;
    }
}
