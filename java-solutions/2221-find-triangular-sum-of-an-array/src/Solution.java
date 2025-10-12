import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sichu huang
 * @since 2025/09/30 08:14
 */
public class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> current = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (current.size() > 1) {
            List<Integer> newNums = new ArrayList<>();
            for (int i = 0; i < current.size() - 1; ++i) {
                newNums.add((current.get(i) + current.get(i + 1)) % 10);
            }
            current = newNums;
        }
        return current.get(0);
    }
}
