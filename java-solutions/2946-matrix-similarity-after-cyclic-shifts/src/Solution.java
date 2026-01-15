/**
 * @author sichu huang
 * @since 2026/01/15 16:33
 */
public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                if (ints[j] != ints[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
