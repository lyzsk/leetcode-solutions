import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/08/19
 **/
public class Solution {
    /**
     * freqMap记录 {nums[i] : nums[i]出现次数}
     * tailMap记录 {nums[i] : 以nums[i]为末尾的子序列出现次数}
     *
     * @param nums given nums
     * @return True or False
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>(16);
        Map<Integer, Integer> tailMap = new HashMap<>(16);
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);
        }
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            if (freq > 0) {
                int prevTailFreq = tailMap.getOrDefault(num - 1, 0);
                if (prevTailFreq > 0) {
                    freqMap.put(num, freq - 1);
                    tailMap.put(num - 1, prevTailFreq - 1);
                    tailMap.put(num, tailMap.getOrDefault(num, 0) + 1);
                } else {
                    int freq1 = freqMap.getOrDefault(num + 1, 0);
                    int freq2 = freqMap.getOrDefault(num + 2, 0);
                    if (freq1 > 0 && freq2 > 0) {
                        freqMap.put(num, freq - 1);
                        freqMap.put(num + 1, freq1 - 1);
                        freqMap.put(num + 2, freq2 - 1);
                        tailMap.put(num + 2, tailMap.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
