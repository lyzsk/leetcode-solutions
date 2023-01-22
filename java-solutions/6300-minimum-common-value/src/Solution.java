import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/01/21
 **/
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int num : map1.keySet()) {
            if (map2.containsKey(num)) {
                res = Math.min(res, num);
            }
        }
        for (int num : map2.keySet()) {
            if (map1.containsKey(num)) {
                res = Math.min(res, num);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
