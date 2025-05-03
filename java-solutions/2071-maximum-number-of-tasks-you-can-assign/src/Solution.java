import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/05/01 12:57
 */
public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 1, right = Math.min(tasks.length, workers.length), res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(tasks, workers, pills, strength, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills, m = workers.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int ptr = m - 1;
        for (int i = mid - 1; i >= 0; i--) {
            while (ptr >= m - mid && workers[ptr] + strength >= tasks[i]) {
                deque.addFirst(workers[ptr--]);
            }
            if (deque.isEmpty()) {
                return false;
            } else if (deque.getLast() >= tasks[i]) {
                deque.pollLast();
            } else {
                if (p == 0) {
                    return false;
                }
                --p;
                deque.poll();
            }
        }
        return true;
    }
}
