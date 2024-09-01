/**
 * @author sichu huang
 * @date 2024/09/01
 **/
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, res[i / n], 0, n);
        }
        return res;
    }
}
