import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/11/19 18:00
 */
public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (original == num) {
                original *= 2;
            }
        }
        return original;
    }
}
