import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/10/10
 **/
public class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i;
        }
        Arrays.sort(arr, (i, j) -> ((Integer)nums[i]).compareTo(nums[j]));
        int res = 0;
        int m = n;
        for (int i : arr) {
            res = Math.max(res, i - m);
            m = Math.min(m, i);
        }
        return res;
    }
}
