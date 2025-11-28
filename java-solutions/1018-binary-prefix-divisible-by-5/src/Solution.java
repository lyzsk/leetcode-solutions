import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/11/24 23:55
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            res.add(prefix == 0);
        }
        return res;
    }
}
