import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/12/05
 **/
public class Solution {
    public int countNicePairs(int[] nums) {
        //    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //    nums[i] - rev(nums[i]) == nums[j] - rev[nums[j])
        final int MOD = (int)(1e9 + 7);
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - rev(nums[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long res = 0;
        for (int key : map.keySet()) {
            // 1 <= nums[i] <= 10^5, freq * (freq - 1) > Integer.MAX_VALUE
            long freq = map.get(key);
            res += (freq * (freq - 1) / 2) % MOD;
        }
        return (int)(res % MOD);
    }

    private int rev(int num) {
        int res = 0;
        while (num > 0) {
            int digit = num % 10;
            res = res * 10 + digit;
            num /= 10;
        }
        return res;
    }
}
