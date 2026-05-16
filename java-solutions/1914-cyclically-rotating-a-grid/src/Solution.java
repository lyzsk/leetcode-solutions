import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/05/09 17:19
 */
public class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int nlayer = Math.min(m / 2, n / 2);
        for (int layer = 0; layer < nlayer; ++layer) {
            List<Integer> r = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            List<Integer> val = new ArrayList<>();
            for (int i = layer; i < m - layer - 1; ++i) {
                r.add(i);
                c.add(layer);
                val.add(grid[i][layer]);
            }
            for (int j = layer; j < n - layer - 1; ++j) {
                r.add(m - layer - 1);
                c.add(j);
                val.add(grid[m - layer - 1][j]);
            }
            for (int i = m - layer - 1; i > layer; --i) {
                r.add(i);
                c.add(n - layer - 1);
                val.add(grid[i][n - layer - 1]);
            }
            for (int j = n - layer - 1; j > layer; --j) {
                r.add(layer);
                c.add(j);
                val.add(grid[layer][j]);
            }
            int total = val.size();
            int kk = k % total;

            for (int i = 0; i < total; ++i) {
                int idx = (i + total - kk) % total;
                grid[r.get(i)][c.get(i)] = val.get(idx);
            }
        }
        return grid;
    }
}
