import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @date 2024/06/15
 **/
public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int cur = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            while (cur < n && arr[cur][0] <= w) {
                maxheap.add(arr[cur][1]);
                ++cur;
            }
            if (!maxheap.isEmpty()) {
                w += maxheap.poll();
            } else {
                break;
            }
        }
        return w;
    }
}
