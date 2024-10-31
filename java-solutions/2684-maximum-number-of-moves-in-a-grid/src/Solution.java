import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2024/10/29 18:15
 */
public class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(i);
        }
        for (int j = 1; j < n; j++) {
            Set<Integer> q2 = new HashSet<>();
            for (int i : set) {
                for (int i2 = i - 1; i2 <= i + 1; i2++) {
                    if (0 <= i2 && i2 < m && grid[i][j - 1] < grid[i2][j]) {
                        q2.add(i2);
                    }
                }
            }
            set = q2;
            if (set.isEmpty()) {
                return j - 1;
            }
        }
        return n - 1;
    }
}
