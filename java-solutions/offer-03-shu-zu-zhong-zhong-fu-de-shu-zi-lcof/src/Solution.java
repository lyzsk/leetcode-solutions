import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/12/24
 **/
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
