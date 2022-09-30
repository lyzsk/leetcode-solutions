import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/09/30
 **/
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);
        int presum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ++presum;
            } else {
                --presum;
            }
            if (map.containsKey(presum)) {
                res = Math.max(res, i - map.get(presum));
            } else {
                map.put(presum, i);
            }
        }
        return res;
    }
}
