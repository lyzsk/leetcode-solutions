import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/04/09 14:20
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                set.add(x);
            }
        }
        return set.size();
    }
}
