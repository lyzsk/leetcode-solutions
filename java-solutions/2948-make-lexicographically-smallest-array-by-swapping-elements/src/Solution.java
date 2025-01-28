import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2025/01/25 12:29
 */
public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] res = new int[n];
        int[] link = new int[n];
        Integer[] indexs = new Integer[n];
        Arrays.setAll(indexs, (i) -> i);
        Arrays.sort(indexs, Comparator.comparingInt(o -> nums[o]));
        for (int i = 1, linkIndex = 0; i < n; i++) {
            if (nums[indexs[i]] - nums[indexs[i - 1]] > limit) {
                link[++linkIndex] = i;
            }
            res[indexs[i]] = linkIndex;
        }
        for (int i = 0; i < n; i++) {
            res[i] = nums[indexs[link[res[i]]++]];
        }
        return res;
    }
}
