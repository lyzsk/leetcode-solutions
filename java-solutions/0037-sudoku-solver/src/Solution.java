import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/08/31 20:40
 */
public class Solution {
    private final int[] line = new int[9];
    private final int[] column = new int[9];
    private final int[][] block = new int[3][3];
    private final List<int[]> spaces = new ArrayList<>();
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char)(digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }
}
