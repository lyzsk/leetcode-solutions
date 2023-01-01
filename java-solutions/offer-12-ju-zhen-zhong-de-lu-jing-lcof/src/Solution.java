/**
 * @author sichu
 * @date 2023/01/01
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean res = false;
        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = backtrack(used, board, word, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }

    private boolean backtrack(boolean[][] used, char[][] board, String word, int startX, int startY, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }
        if (startX < 0 || startY < 0 || startX > board.length - 1 || startY > board[0].length - 1) {
            return false;
        }
        if (!used[startX][startY]) {
            if (board[startX][startY] == word.charAt(wordIdx)) {
                used[startX][startY] = true;
                boolean up = backtrack(used, board, word, startX, startY - 1, wordIdx + 1);
                boolean down = backtrack(used, board, word, startX, startY + 1, wordIdx + 1);
                boolean left = backtrack(used, board, word, startX - 1, startY, wordIdx + 1);
                boolean right = backtrack(used, board, word, startX + 1, startY, wordIdx + 1);
                if (up || down || left || right) {
                    return true;
                }
                used[startX][startY] = false;
            }
        }
        return false;
    }
}
