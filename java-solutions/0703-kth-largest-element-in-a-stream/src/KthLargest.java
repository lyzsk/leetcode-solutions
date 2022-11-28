import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/11/27
 **/
public class KthLargest {
    int k;
    private PriorityQueue<Integer> minheap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minheap.add(val);
        if (minheap.size() > k) {
            minheap.poll();
        }
        return minheap.peek();
    }
}
