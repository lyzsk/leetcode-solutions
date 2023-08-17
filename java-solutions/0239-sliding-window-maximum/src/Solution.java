import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // int[] {num, idx}
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            maxheap.add(new int[] {nums[i], i});
        }
        int[] res = new int[n - k + 1];
        res[0] = maxheap.peek()[0];
        for (int i = k; i < n; i++) {
            maxheap.add(new int[] {nums[i], i});
            while (maxheap.peek()[1] <= i - k) {
                maxheap.poll();
            }
            res[i - k + 1] = maxheap.peek()[0];
        }
        return res;
    }
}
