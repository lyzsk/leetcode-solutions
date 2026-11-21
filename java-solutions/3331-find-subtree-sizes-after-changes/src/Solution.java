import java.util.*;

/**
 *
 * @author sichu huang
 * @since 2026/11/21
 */
public class Solution {
    private Map<Integer, List<Integer>> gOld;
    private Map<Character, List<Integer>> records;
    private int[] res;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;

        this.gOld = new HashMap<>();
        for (int i = 1; i < n; i++) {
            gOld.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }

        this.records = new HashMap<>();
        this.res = new int[n];

        operate(0);
        return res;
    }

    private void operate(int u) {
        res[u] += 1;
        records.computeIfAbsent(s.charAt(u), k -> new ArrayList<>()).add(u);
        for (int v : gOld.getOrDefault(u, Collections.emptyList())) {
            operate(v);
            List<Integer> rec = records.getOrDefault(s.charAt(v), Collections.emptyList());
            int uNew = rec.isEmpty() ? u : rec.get(rec.size() - 1);
            res[uNew] += res[v];
        }
        List<Integer> r = records.get(s.charAt(u));
        r.remove(r.size() - 1);
    }
}
