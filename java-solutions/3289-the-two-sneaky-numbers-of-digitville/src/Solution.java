import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/10/31 19:38
 */
public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) == 2) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
