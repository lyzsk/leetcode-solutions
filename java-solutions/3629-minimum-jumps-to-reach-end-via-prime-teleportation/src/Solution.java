import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/05/08 15:20
 */
public class Solution {
    private static final int MX = 1000001;
    private static final List<Integer>[] factors = new ArrayList[MX];

    static {
        for (int i = 0; i < MX; i++) {
            factors[i] = new ArrayList<>();
        }
        for (int i = 2; i < MX; i++) {
            if (factors[i].isEmpty()) {
                for (int j = i; j < MX; j += i) {
                    factors[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int p : factors[nums[i]]) {
                edges.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }
        int res = 0;
        boolean[] seen = new boolean[n];
        seen[0] = true;
        List<Integer> q = new ArrayList<>();
        q.add(0);
        while (true) {
            List<Integer> q2 = new ArrayList<>();
            for (int i : q) {
                if (i == n - 1) {
                    return res;
                }
                if (i > 0 && !seen[i - 1]) {
                    seen[i - 1] = true;
                    q2.add(i - 1);
                }
                if (i < n - 1 && !seen[i + 1]) {
                    seen[i + 1] = true;
                    q2.add(i + 1);
                }
                if (factors[nums[i]].size() == 1) {
                    int p = nums[i];
                    if (edges.containsKey(p)) {
                        for (int j : edges.get(p)) {
                            if (!seen[j]) {
                                seen[j] = true;
                                q2.add(j);
                            }
                        }
                        edges.get(p).clear();
                    }
                }
            }
            q = q2;
            res++;
        }
    }
}
