import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2024/12/12 18:27
 */
public class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            maxheap.offer(gift);
        }
        while (k > 0) {
            k--;
            int x = maxheap.poll();
            maxheap.offer((int)Math.sqrt(x));
        }
        long res = 0;
        while (!maxheap.isEmpty()) {
            res += maxheap.poll();
        }
        return res;
    }
}
