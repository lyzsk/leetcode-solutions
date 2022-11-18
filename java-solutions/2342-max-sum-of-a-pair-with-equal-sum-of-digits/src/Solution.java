import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/11/18
 **/
public class Solution {
    public int maximumSum(int[] nums) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (map.containsKey(sum)) {
                res = Math.max(res, map.get(sum) + nums[i]);
                if (nums[i] > map.get(sum)) {
                    map.put(sum, nums[i]);
                }
            } else {
                map.put(sum, nums[i]);
            }
        }
        return res;
    }
}
