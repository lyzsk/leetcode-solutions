import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 优先队列先排[][1], 如果相等, 排[][0]
 * 但是要先拷贝tasks, 因为res与原tasks有关
 *
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        idx.sort(Comparator.comparingInt(o -> tasks[o][0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        int[] res = new int[n];
        int time = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                time = Math.max(time, tasks[idx.get(k)][0]);
            }
            while (k < n && tasks[idx.get(k)][0] <= time) {
                pq.offer(new int[] {idx.get(k), tasks[idx.get(k)][1]});
                ++k;
            }
            int[] temp = pq.poll();
            res[i] = temp[0];
            time += temp[1];
        }
        return res;
    }
}
