import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/11/10 22:44
 */
public class Solution {
    public int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int num : nums) {
            while (!list.isEmpty() && list.get(list.size() - 1) > num) {
                list.remove(list.size() - 1);
            }
            if (num == 0) {
                continue;
            }
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                res++;
                list.add(num);
            }
        }
        return res;
    }
}