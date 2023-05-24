import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/01/23
 **/
public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, (o1, o2) -> Integer.compare(nums2[o2], nums2[o1]));
        long res = 0L;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        long sum1 = 0L;
        for (int idx : idxs) {
            int x = nums1[idx];
            int y = nums2[idx];
            while (minheap.size() > k - 1) {
                sum1 -= minheap.poll();
            }
            minheap.offer(x);
            sum1 += x;
            if (minheap.size() == k) {
                long cur = sum1 * y;
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
