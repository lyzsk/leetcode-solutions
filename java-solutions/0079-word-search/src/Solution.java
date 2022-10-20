/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        int flag = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    ++flag;
                } else if (board[i][j] == word.charAt(word.length() - 1)) {
                    --flag;
                }
            }
        }
        if (flag > 0) {
            word = new StringBuilder(word).reverse().toString();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int startX, int startY, int wordIndex) {
        if (startX < 0 || startY < 0 || startX > board.length - 1 || startY > board[0].length - 1
            || board[startX][startY] == '.' || board[startX][startY] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        char temp = board[startX][startY];
        board[startX][startY] = '.';
        boolean res =
            dfs(board, word, startX, startY - 1, wordIndex + 1) || dfs(board, word, startX, startY + 1, wordIndex + 1)
                || dfs(board, word, startX - 1, startY, wordIndex + 1) || dfs(board, word, startX + 1, startY,
                wordIndex + 1);
        board[startX][startY] = temp;
        return res;
    }

    // private static boolean backtrack(char[][] board, String word, boolean[][] used, int startX, int startY,
    //     int wordIndex) {
    //     if (wordIndex == word.length()) {
    //         return true;
    //     }
    //     if (startX < 0 || startY < 0 || startX > board.length - 1 || startY > board[0].length - 1) {
    //         return false;
    //     }
    //     if (!used[startX][startY]) {
    //         if (word.charAt(wordIndex) == board[startX][startY]) {
    //             used[startX][startY] = true;
    //             boolean up = backtrack(board, word, used, startX, startY - 1, wordIndex + 1);
    //             boolean down = backtrack(board, word, used, startX, startY + 1, wordIndex + 1);
    //             boolean left = backtrack(board, word, used, startX - 1, startY, wordIndex + 1);
    //             boolean right = backtrack(board, word, used, startX + 1, startY, wordIndex + 1);
    //             if (up || down || left || right) {
    //                 return true;
    //             }
    //             used[startX][startY] = false;
    //         }
    //     }
    //     return false;
    // }
    //
    // public boolean exist(char[][] board, String word) {
    //     boolean[][] used = new boolean[board.length][board[0].length];
    //     boolean flag = false;
    //     for (int i = 0; i < board.length; i++) {
    //         for (int j = 0; j < board[0].length; j++) {
    //             flag = backtrack(board, word, used, i, j, 0);
    //             if (flag) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return flag;
    // }
}
