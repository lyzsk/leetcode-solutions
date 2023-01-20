import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/01/20
 **/
public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>(logs.length);
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(time);
        }
        for (Set<Integer> minutes : map.values()) {
            int cnt = minutes.size();
            ++res[cnt - 1];
        }
        return res;
    }
}
