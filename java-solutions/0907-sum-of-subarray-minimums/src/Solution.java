import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/10/28
 **/
public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        }
        long res = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            res = (res + (long)left[i] * right[i] * arr[i]) % MOD;
        }
        return (int)res;
    }
}
