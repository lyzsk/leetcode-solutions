import java.util.*;

/**
 * @author sichu huang
 * @since 2025/11/06 23:28
 */
public class Solution {

    private final Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    private int[] parent, size;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        size = new int[c];
        boolean[] offline = new boolean[c];
        for (int i = 0; i < c; i++) {
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);
            map.put(i, pq);
        }
        for (int[] conn : connections) {
            int u = conn[0] - 1, v = conn[1] - 1;
            Union(u, v);
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int node = query[1] - 1;
            if (type == 1) {
                if (!offline[node]) {
                    res.add(node + 1);
                    continue;
                }
                int par = findParent(node);
                PriorityQueue<Integer> pq = map.get(par);
                while (!pq.isEmpty() && offline[pq.peek()]) {
                    pq.poll();
                }
                res.add(pq.isEmpty() ? -1 : pq.peek() + 1);
            } else {
                offline[node] = true;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    private void Union(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);

        if (up == vp) {
            return;
        }

        if (size[up] > size[vp]) {
            size[up] += size[vp];
            parent[vp] = up;
            PriorityQueue<Integer> pqV = map.get(vp);
            PriorityQueue<Integer> pqU = map.get(up);
            while (!pqV.isEmpty()) {
                pqU.offer(pqV.poll());
            }
        } else {
            size[vp] += size[up];
            parent[up] = vp;
            PriorityQueue<Integer> pqU = map.get(up);
            PriorityQueue<Integer> pqV = map.get(vp);
            while (!pqU.isEmpty()) {
                pqV.offer(pqU.poll());
            }
        }
    }
}
