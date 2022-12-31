import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/11/21
 **/
public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int res = 0;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] pos = deque.removeFirst();
                if ((pos[0] == 0 || pos[0] == maze.length - 1 || pos[1] == 0 || pos[1] == maze[0].length - 1) && (
                    pos[0] != entrance[0] || pos[1] != entrance[1])) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int mx = pos[0] + dir[0];
                    int my = pos[1] + dir[1];
                    if (mx >= 0 && mx < maze.length && my >= 0 && my < maze[0].length && maze[mx][my] != '+') {
                        deque.addLast(new int[] {mx, my});
                        maze[mx][my] = '+';
                    }
                }
            }
            ++res;
        }
        return -1;
    }
}
