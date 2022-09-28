import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/08/20
 **/
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int need = target - startFuel;
        int res = 0;
        int ptr = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (ptr < stations.length || !queue.isEmpty()) {
            if (need <= 0) {
                return res;
            }
            while (ptr < stations.length && stations[ptr][0] <= startFuel) {
                queue.add(stations[ptr][1]);
                ++ptr;
            }
            if (ptr < stations.length && stations[ptr][0] > startFuel && queue.isEmpty()) {
                return -1;
            }
            if (!queue.isEmpty()) {
                int add = queue.poll();
                startFuel += add;
                need -= add;
                res += 1;
            }
        }
        return need <= 0 ? res : -1;
    }
}
