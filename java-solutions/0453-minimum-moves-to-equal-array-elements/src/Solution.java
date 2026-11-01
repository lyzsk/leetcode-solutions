import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/11/01
 */
public class Solution {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
