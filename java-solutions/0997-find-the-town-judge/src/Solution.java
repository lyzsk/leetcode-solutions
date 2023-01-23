/**
 * @author sichu
 * @date 2023/01/23
 **/
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] x : trust) {
            ++inDegrees[x[1]];
            ++outDegrees[x[0]];
        }
        for (int i = 1; i <= n; i++) {
            if (outDegrees[i] == 0 && inDegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
