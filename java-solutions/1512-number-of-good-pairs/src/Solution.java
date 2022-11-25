import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/11/25
 **/
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            res += v * (v - 1) / 2;
        }
        return res;
        // int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             ++res;
        //         }
        //     }
        // }
        // return res;
    }
}
