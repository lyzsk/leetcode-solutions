import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author sichu huang
 * @since 2026/05/17 12:52
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int n = arr.length;
        boolean[] used = new boolean[n];
        used[start] = true;
        Deque<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : new int[] {u + arr[u], u - arr[u]}) {
                if (0 <= v && v < n && !used[v]) {
                    if (arr[v] == 0) {
                        return true;
                    }
                    q.offer(v);
                    used[v] = true;
                }
            }
        }

        return false;
    }
}
