import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/12/28
 **/
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        int res = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int pile : piles) {
            maxheap.offer(pile);
        }
        while (k > 0) {
            int num = maxheap.poll();
            maxheap.offer(num - (num >> 1));
            --k;
        }
        while (maxheap.size() > 0) {
            res += maxheap.poll();
        }
        return res;
    }
}
