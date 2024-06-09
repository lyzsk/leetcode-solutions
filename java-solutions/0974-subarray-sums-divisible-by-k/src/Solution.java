import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/06/09
 **/
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            int modulus = (sum % k + k) % k;
            int same = map.getOrDefault(modulus, 0);
            res += same;
            map.put(modulus, same + 1);
        }
        return res;
    }
}
