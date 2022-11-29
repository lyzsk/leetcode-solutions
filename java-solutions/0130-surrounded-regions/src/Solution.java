/**
 * @author sichu
 * @date 2022/11/28
 **/
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board[0] == null) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int startX, int startY) {
        if (startX < 0 || startY < 0 || startX >= board.length || startY >= board[0].length
            || board[startX][startY] != 'O') {
            return;
        }
        board[startX][startY] = 'Y';
        dfs(board, startX - 1, startY);
        dfs(board, startX + 1, startY);
        dfs(board, startX, startY - 1);
        dfs(board, startX, startY + 1);
    }
}
