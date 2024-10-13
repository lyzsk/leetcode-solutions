import java.util.*;

/**
 * @author sichu huang
 * @date 2024/10/11
 **/
public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] arrivals = new int[n][2];
        int[][] leaves = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrivals[i][0] = times[i][0];
            arrivals[i][1] = i;
            leaves[i][0] = times[i][1];
            leaves[i][1] = i;
        }
        Arrays.sort(arrivals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(leaves, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minheap.offer(i);
        }
        int j = 0;
        for (int[] arrival : arrivals) {
            while (j < n && leaves[j][0] <= arrival[0]) {
                minheap.offer(map.get(leaves[j][1]));
                j++;
            }
            map.put(arrival[1], minheap.poll());
            if (arrival[1] == targetFriend) {
                return map.get(targetFriend);
            }
        }
        return -1;
    }
}
