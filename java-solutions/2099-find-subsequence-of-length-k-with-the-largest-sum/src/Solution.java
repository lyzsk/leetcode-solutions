import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2025/06/29 02:08
 */
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2];
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }
        Arrays.sort(vals, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        Arrays.sort(vals, 0, k, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
    }
}
