import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/05/22 17:25
 */
public class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            operations += deltaArray[i];
            while (j < queries.length && queries[j][0] == i) {
                maxheap.offer(queries[j][1]);
                j++;
            }
            while (operations < nums[i] && !maxheap.isEmpty() && maxheap.peek() >= i) {
                operations += 1;
                deltaArray[maxheap.poll() + 1] -= 1;
            }
            if (operations < nums[i]) {
                return -1;
            }
        }
        return maxheap.size();
    }
}
