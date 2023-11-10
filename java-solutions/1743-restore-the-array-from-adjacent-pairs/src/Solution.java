import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/11/10
 **/
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>(16);
        for (int[] adjacentPair : adjacentPairs) {
            graph.computeIfAbsent(adjacentPair[0], k -> new ArrayList<>()).add(adjacentPair[1]);
            graph.computeIfAbsent(adjacentPair[1], k -> new ArrayList<>()).add(adjacentPair[0]);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                res.add(entry.getKey());
                res.add(entry.getValue().get(0));
                break;
            }
        }
        while (res.size() < adjacentPairs.length + 1) {
            int last = res.get(res.size() - 1);
            int prev = res.get(res.size() - 2);
            List<Integer> candidates = graph.get(last);
            int nextElement = candidates.get(0) != prev ? candidates.get(0) : candidates.get(1);
            res.add(nextElement);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
