/**
 *
 * @author sichu huang
 * @since 2026/10/27
 */
public class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(i == 0 || j == n - 1 ? '.' : '#');
            }
            grid[i] = sb.toString();
        }
        return grid;
    }
}
