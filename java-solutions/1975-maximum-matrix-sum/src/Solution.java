/**
 * @author sichu huang
 * @since 2024/11/24 18:52
 */
public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int neg = 0, min = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] < 0) {
                    neg++;
                }
                min = Math.min(min, Math.abs(ints[j]));
                res += Math.abs(ints[j]);
            }
        }
        return (neg & 1) == 0 ? res : res - min * 2L;
    }
}
