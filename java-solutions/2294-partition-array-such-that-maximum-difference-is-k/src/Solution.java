import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/06/19 12:08
 */
public class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MIN_VALUE / 2;
        for (int x : nums) {
            if (x - min > k) {
                res++;
                min = x;
            }
        }
        return res;
    }
}
