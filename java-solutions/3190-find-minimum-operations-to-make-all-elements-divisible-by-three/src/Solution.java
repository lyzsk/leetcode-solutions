import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/11/22 12:03
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums).map(x -> Math.min(x % 3, 3 - x % 3)).sum();
    }
}
