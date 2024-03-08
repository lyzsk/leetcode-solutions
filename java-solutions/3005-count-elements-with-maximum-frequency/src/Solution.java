import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/03/08
 **/
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        int maxFreq = Integer.MIN_VALUE;
        for (Integer freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        for (Integer freq : map.values()) {
            if (freq == maxFreq) {
                res += freq;
            }
        }
        return res;
    }
}
