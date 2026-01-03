import java.util.List;

/**
 * @author sichu huang
 * @since 2025/12/30 16:17
 */
public class Solution {
    private boolean[] vis;
    private int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }
}
