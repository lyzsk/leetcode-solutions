import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
