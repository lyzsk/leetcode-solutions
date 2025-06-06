import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/06/04 01:26
 */
public class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
        int[] initialBoxes) {
        int n = status.length;
        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            canOpen[i] = (status[i] == 1);
        }
        Deque<Integer> minheap = new ArrayDeque<>();
        int res = 0;
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                minheap.offer(box);
                used[box] = true;
                res += candies[box];
            }
        }
        while (!minheap.isEmpty()) {
            int bigBox = minheap.poll();
            for (int key : keys[bigBox]) {
                canOpen[key] = true;
                if (!used[key] && hasBox[key]) {
                    minheap.offer(key);
                    used[key] = true;
                    res += candies[key];
                }
            }
            for (int box : containedBoxes[bigBox]) {
                hasBox[box] = true;
                if (!used[box] && canOpen[box]) {
                    minheap.offer(box);
                    used[box] = true;
                    res += candies[box];
                }
            }
        }
        return res;
    }
}
