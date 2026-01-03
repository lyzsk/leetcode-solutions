import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2026/01/02 22:04
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> found = new HashSet<>();
        for (int num : nums) {
            if (!found.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
