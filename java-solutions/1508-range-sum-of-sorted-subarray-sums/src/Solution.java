import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/08/04
 **/
public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = (int)(1e9 + 7);
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res = (res + sums[i]) % MODULO;
        }
        return res;
    }
}
