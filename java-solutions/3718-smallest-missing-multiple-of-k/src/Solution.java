import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sichu huang
 * @since 2026/08/25
 */
public class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int res = k;
        while (seen.contains(res)) {
            res += k;
        }
        return res;
    }
}
