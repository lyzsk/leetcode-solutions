import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/10/03
 **/
public class Solution {
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int y = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(y, i);
            y = (y + nums[i]) % p;
            if (map.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - map.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }
}
