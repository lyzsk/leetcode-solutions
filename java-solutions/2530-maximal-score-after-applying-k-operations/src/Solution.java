import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxheap.offer(num);
        }
        while (k > 0) {
            int temp = maxheap.poll();
            res += temp;
            temp = temp / 3 + (temp % 3 == 0 ? 0 : 1);
            maxheap.offer(temp);
            --k;
        }
        return res;
    }
}
