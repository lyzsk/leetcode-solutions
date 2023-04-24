import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/04/24
 **/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int stone : stones) {
            maxheap.offer(stone);
        }
        while (maxheap.size() > 1) {
            int y = maxheap.poll();
            int x = maxheap.poll();
            if (x != y) {
                maxheap.offer(y - x);
            }
        }
        return maxheap.isEmpty() ? 0 : maxheap.poll();
    }
}
