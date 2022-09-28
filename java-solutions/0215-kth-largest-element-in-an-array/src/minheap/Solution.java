package minheap;

import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/08/16
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Integer topElement = minHeap.peek();
            if (nums[i] > topElement) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
