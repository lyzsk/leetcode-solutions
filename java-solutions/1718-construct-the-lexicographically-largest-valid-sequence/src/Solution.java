import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/18
 **/
public class Solution {
    private void backtrack(int[] res, boolean[] visited, int pos, int n) {
        if (pos == res.length) {
            return res;
        }
        if (res[pos] == -1) {
            return backtrack(res, visited, pos + 1, n);
        }
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        Arrays.fill(res, -1);
        boolean[] visited = new boolean[n];
        backtrack(res, visited, 0, n);
        return res;
    }
}
