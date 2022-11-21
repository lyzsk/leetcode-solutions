import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/11/21
 **/
public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.removeFirst();
                if ((pos[0] == maze.length - 1 || pos[1] == maze[0].length - 1 || pos[0] == 0 || pos[1] == 0) && (
                    pos[0] != entrance[0] || pos[1] != entrance[1])) {
                    return res;
                }
                for (int[] arr : dir) {
                    int mx = pos[0] + arr[0];
                    int my = pos[1] + arr[1];
                    if (mx >= 0 && mx < maze.length && my >= 0 && my < maze[0].length && maze[mx][my] != '+') {
                        queue.addLast(new int[] {mx, my});
                        maze[mx][my] = '+';
                    }
                }
            }
            ++res;
        }
        return -1;
    }
}
