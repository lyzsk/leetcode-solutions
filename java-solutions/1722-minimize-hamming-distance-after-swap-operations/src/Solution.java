import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/04/21 15:04
 */
public class Solution {
    private int[] fa;
    private int[] rank;

    private int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[y] = x;
        if (rank[x] == rank[y]) {
            rank[x]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        fa = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }

        for (int[] pair : allowedSwaps) {
            union(pair[0], pair[1]);
        }

        Map<Integer, Map<Integer, Integer>> sets = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = find(i);
            sets.putIfAbsent(f, new HashMap<>());
            Map<Integer, Integer> cnt = sets.get(f);
            cnt.put(source[i], cnt.getOrDefault(source[i], 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int f = find(i);
            Map<Integer, Integer> cnt = sets.get(f);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                cnt.put(target[i], cnt.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        return res;
    }
}
