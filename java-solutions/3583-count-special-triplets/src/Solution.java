import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/12/09 16:48
 */
public class Solution {

    private static final int MOD = (int)(1e9 + 7);

    public int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            pos.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
        }
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int target = nums[i] * 2;
            List<Integer> targetPos = pos.get(target);
            if (targetPos != null && targetPos.size() > 1 && targetPos.get(0) < i) {
                int[] lr = upperBound(targetPos, i);
                int l = lr[0];
                int r = lr[1];
                if (nums[i] == 0) {
                    l--;
                }
                res = (int)((res + (long)l * r) % MOD);
            }
        }
        return res;
    }

    private int[] upperBound(List<Integer> arr, int i) {
        int l = 0, r = arr.size() - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (i >= arr.get(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[] {l + 1, arr.size() - 1 - l};
    }
}
