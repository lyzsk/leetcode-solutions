import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2024/12/01 17:59
 */
public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num >> 1))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
