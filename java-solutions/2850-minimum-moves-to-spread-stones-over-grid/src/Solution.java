import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/09/14
 **/
public class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 1) {
                    from.add(new int[] {i, j});
                } else {
                    to.add(new int[] {i, j});
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (List<int[]> arr : permutations(from)) {
            int total = 0;
            for (int i = 0; i < arr.size(); i++) {
                int[] f = arr.get(i);
                int[] t = to.get(i);
                total += Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
            }
            res = Math.min(res, total);
        }
        return res;
    }

    private List<List<int[]>> permutations(List<int[]> arr) {
        List<List<int[]>> res = new ArrayList<>();
        permute(arr, 0, res);
        return res;
    }

    private void permute(List<int[]> arr, int start, List<List<int[]>> res) {
        if (start == arr.size()) {
            res.add(arr);
        }
        for (int i = start; i < arr.size(); i++) {
            swap(arr, start, i);
            permute(arr, start + 1, res);
            swap(arr, start, i);
        }
    }

    private void swap(List<int[]> arr, int i, int j) {
        int[] tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
