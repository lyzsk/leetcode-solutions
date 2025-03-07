/**
 * @author sichu huang
 * @since 2025/03/06 18:24
 */
public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                count[ints[j]]++;
            }
        }
        int[] res = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                res[0] = i;
            }
            if (count[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}
