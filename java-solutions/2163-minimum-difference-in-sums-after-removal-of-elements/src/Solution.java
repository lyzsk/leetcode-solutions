import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/07/18 08:39
 */
public class Solution {
    public long minimumDifference(int[] nums) {
        int n3 = nums.length, n = n3 / 3;
        long[] part1 = new long[n + 1];
        long sum = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            maxheap.add(nums[i]);
        }
        part1[0] = sum;
        for (int i = n; i < n * 2; ++i) {
            sum += nums[i];
            maxheap.add(nums[i]);
            sum -= maxheap.poll();
            part1[i - (n - 1)] = sum;
        }
        long part2 = 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = n * 3 - 1; i >= n * 2; --i) {
            part2 += nums[i];
            minheap.add(nums[i]);
        }
        long res = part1[n] - part2;
        for (int i = n * 2 - 1; i >= n; --i) {
            part2 += nums[i];
            minheap.add(nums[i]);
            part2 -= minheap.poll();
            res = Math.min(res, part1[i - n] - part2);
        }
        return res;
    }
}
