import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2024/02/17
 **/
public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = heights.length;
        for (int i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                maxheap.offer(diff);
                bricks -= diff;
                if (bricks < 0) {
                    if (ladders > 0) {
                        --ladders;
                        bricks += maxheap.poll();
                    } else {
                        return i - 1;
                    }
                }
            }
        }
        return n - 1;
    }
}