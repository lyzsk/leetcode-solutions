import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/04/18 01:46
 */
public class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length, res = (int)1e6;

        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(nums[i])) {
                res = Math.min(res, i - mpp.get(nums[i]));
            }
            mpp.put(reverse(nums[i]), i);
        }

        return res == (int)1e6 ? -1 : res;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}
