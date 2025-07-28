import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/07/26 00:44
 */
public class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return positiveNumsSet.stream().mapToInt(Integer::intValue).sum();
    }
}
