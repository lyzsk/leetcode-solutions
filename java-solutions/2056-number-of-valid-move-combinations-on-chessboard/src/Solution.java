import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/12/23 15:47
 */
public class Solution {
    private static int[][] rookDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] bishopDirections = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static int[][] queenDirections =
        {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private String[] pieces;
    private int[][] positions;
    private int n;
    private int res = 0;
    private List<Movement> stack = new ArrayList<>();

    public int countCombinations(String[] pieces, int[][] positions) {
        this.pieces = pieces;
        this.positions = positions;
        this.n = pieces.length;
        dfs(0);
        return res;
    }

    private void dfs(int u) {
        if (u == n) {
            res++;
            return;
        }
        int[][] directions;
        if ("rook".equals(pieces[u])) {
            directions = rookDirections;
        } else if ("queen".equals(pieces[u])) {
            directions = queenDirections;
        } else {
            directions = bishopDirections;
        }

        stack.add(
            new Movement(positions[u][0], positions[u][1], positions[u][0], positions[u][1], 0, 0));
        if (check(u)) {
            dfs(u + 1);
        }
        stack.remove(stack.size() - 1);

        for (int i = 0; i < directions.length; i++) {
            for (int j = 1; j < 8; j++) {
                int x = positions[u][0] + directions[i][0] * j;
                int y = positions[u][1] + directions[i][1] * j;
                if (x < 1 || x > 8 || y < 1 || y > 8) {
                    break;
                }
                stack.add(new Movement(positions[u][0], positions[u][1], x, y, directions[i][0],
                    directions[i][1]));
                if (check(u)) {
                    dfs(u + 1);
                }
                stack.remove(stack.size() - 1);
            }
        }
    }

    private boolean check(int u) {
        for (int v = 0; v < u; v++) {
            if (stack.get(u).cross(stack.get(v))) {
                return false;
            }
        }
        return true;
    }
}

class Movement {
    public final int START_X;
    public final int START_Y;
    public final int END_X;
    public final int END_Y;
    public final int DX;
    public final int DY;
    public int curX;
    public int curY;

    public Movement(int startX, int startY, int endX, int endY, int dx, int dy) {
        this.START_X = startX;
        this.START_Y = startY;
        this.END_X = endX;
        this.END_Y = endY;
        this.DX = dx;
        this.DY = dy;
        this.curX = startX;
        this.curY = startY;
    }

    public void reset() {
        curX = START_X;
        curY = START_Y;
    }

    public boolean stopped() {
        return curX == END_X && curY == END_Y;
    }

    public void advance() {
        if (!stopped()) {
            curX += DX;
            curY += DY;
        }
    }

    public boolean cross(Movement oth) {
        reset();
        oth.reset();
        while (!stopped() || !oth.stopped()) {
            advance();
            oth.advance();
            if (curX == oth.curX && curY == oth.curY) {
                return true;
            }
        }
        return false;
    }
}