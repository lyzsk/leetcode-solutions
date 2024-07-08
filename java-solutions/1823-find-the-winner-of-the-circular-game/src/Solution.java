import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @date 2024/07/08
 **/
public class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offerLast(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offerLast(queue.pollFirst());
            }
            queue.pollFirst();
        }
        return queue.peekFirst();
    }
}
