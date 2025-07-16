import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/07/08 01:54
 */
public class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                minheap.offer(events[j][1]);
                j++;
            }
            while (!minheap.isEmpty() && minheap.peek() < i) {
                minheap.poll();
            }
            if (!minheap.isEmpty()) {
                minheap.poll();
                res++;
            }
        }

        return res;
    }
}
