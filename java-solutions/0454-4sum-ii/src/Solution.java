import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        int res = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (map.containsKey(-num3 - num4)) {
                    res += map.get(-num3 - num4);
                }
            }
        }
        return res;
    }
}
