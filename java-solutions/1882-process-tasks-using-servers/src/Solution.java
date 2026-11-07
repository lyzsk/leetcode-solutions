import java.util.PriorityQueue;

/**
 *
 * @author sichu huang
 * @since 2026/11/07
 */
public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] res = new int[m];
        PriorityQueue<ServerState> ready = new PriorityQueue<>(
            (a, b) -> (a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight);
        for (int i = 0; i < n; i++) {
            ready.offer(new ServerState(i, servers[i], 0));
        }
        PriorityQueue<ServerState> busy = new PriorityQueue<>((a, b) -> {
            return (a.ending == b.ending) ?
                ((a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight) :
                a.ending - b.ending;
        });
        for (int j = 0; j < m; j++) {
            while (!busy.isEmpty() && busy.peek().ending <= j) {
                ready.offer(busy.poll());
            }
            if (ready.isEmpty()) {
                ServerState top = busy.poll();
                top.ending += tasks[j];
                res[j] = top.idx;
                busy.offer(top);
            } else {
                ServerState serv = ready.poll();
                serv.ending = j + tasks[j];
                res[j] = serv.idx;
                busy.offer(serv);
            }
        }
        return res;
    }

    static class ServerState {
        int idx;
        int weight;
        int ending;

        public ServerState(int i, int w, int e) {
            idx = i;
            weight = w;
            ending = e;
        }
    }
}
