import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/05/31 23:56
 */
public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) {
                    break;
                }
                int[] rc = id2rc(nxt, n);
                if (board[rc[0]][rc[1]] > 0) {
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[] {nxt, p[1] + 1});
                }
            }
        }
        return -1;
    }

    private int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[] {n - 1 - r, c};
    }
}
