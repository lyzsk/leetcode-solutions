import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/09/17
 */
public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int n = arr.length, s = 0, res = n + 1, minL = n;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (pos.containsKey(s - target)) {
                int j = pos.get(s - target), len = i - j;
                res = Math.min(res, len + (j == -1 ? n : arr[j]));
                minL = Math.min(minL, len);
            }
            arr[i] = minL;
            pos.put(s, i);
        }
        return res == n + 1 ? -1 : res;
    }
}
