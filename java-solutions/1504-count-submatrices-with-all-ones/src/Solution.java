import java.util.Stack;

/**
 * @author sichu huang
 * @since 2025/08/21 17:42
 */
public class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int[] heights = new int[n];
        int res = 0;
        for (int[] row : mat) {
            for (int i = 0; i < n; i++) {
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[] {-1, 0, -1});
            for (int i = 0; i < n; i++) {
                int h = heights[i];
                while (stack.peek()[2] >= h) {
                    stack.pop();
                }
                int[] top = stack.peek();
                int j = top[0];
                int prev = top[1];
                int cur = prev + (i - j) * h;
                stack.push(new int[] {i, cur, h});
                res += cur;
            }
        }
        return res;
    }
}
