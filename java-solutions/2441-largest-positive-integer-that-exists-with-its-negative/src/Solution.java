import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/05/13
 **/
public class Solution {
    public int findMaxK(int[] nums) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(-num)) {
                res = Math.max(res, num);
            }
        }
        return res;
    }
}
