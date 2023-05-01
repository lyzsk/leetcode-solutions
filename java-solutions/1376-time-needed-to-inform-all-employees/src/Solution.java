import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/05/01
 **/
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> g = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            g.putIfAbsent(manager[i], new ArrayList<>());
            g.get(manager[i]).add(i);
        }
        return dfs(headID, informTime, g);
    }

    private int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> g) {
        int res = 0;
        for (int neighbor : g.getOrDefault(cur, new ArrayList<>())) {
            res = Math.max(res, dfs(neighbor, informTime, g));
        }
        return informTime[cur] + res;
    }
}
