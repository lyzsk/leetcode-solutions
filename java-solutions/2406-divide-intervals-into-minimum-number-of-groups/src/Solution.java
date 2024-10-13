import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @date 2024/10/12
 **/
public class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int[] cur : intervals) {
            int left = cur[0], right = cur[1];
            if (minheap.isEmpty()) {
                minheap.offer(right);
            } else {
                if (left <= minheap.peek()) {
                    minheap.offer(right);
                } else {
                    minheap.poll();
                    minheap.offer(right);
                }
            }
        }
        return minheap.size();
    }
}
