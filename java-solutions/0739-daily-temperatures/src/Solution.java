import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/12/18
 **/
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peekFirst()]) {
                int prevIndex = stack.removeFirst();
                res[prevIndex] = i - prevIndex;
            }
            stack.addFirst(i);
        }
        return res;
    }
}
