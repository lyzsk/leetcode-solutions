import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2024/11/21 15:12
 */
public class Solution {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] visited = new int[m][n];
        Map<String, Integer> map = new HashMap<>();
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            map.put(x + "," + y, 1);
            visited[x][y] = 1;
        }

        for (int[] wall : walls) {
            int x = wall[0], y = wall[1];
            map.put(x + "," + y, 1);
            visited[x][y] = 1;
        }

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            dfs(r, c + 1, "r", visited, map);
            dfs(r, c - 1, "l", visited, map);
            dfs(r + 1, c, "d", visited, map);
            dfs(r - 1, c, "u", visited, map);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, String dir, int[][] visited, Map<String, Integer> mp) {
        int n = visited.length;
        int m = visited[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return;
        }
        if (mp.containsKey(r + "," + c)) {
            return;
        }
        visited[r][c] = 1;
        switch (dir) {
            case "r":
                dfs(r, c + 1, "r", visited, mp);
                break;
            case "l":
                dfs(r, c - 1, "l", visited, mp);
                break;
            case "u":
                dfs(r - 1, c, "u", visited, mp);
                break;
            case "d":
                dfs(r + 1, c, "d", visited, mp);
                break;
        }
    }
}
