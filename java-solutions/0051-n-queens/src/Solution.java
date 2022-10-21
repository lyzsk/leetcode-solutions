import java.util.*;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    private static void backtrack(List<List<String>> res, int[] queens, int n, Set<Integer> cols, Set<Integer> diag1,
        Set<Integer> diag2, int rowIndex) {
        if (rowIndex == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) {
                continue;
            }
            int diagonal1 = rowIndex - i;
            if (diag1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = rowIndex + i;
            if (diag2.contains(diagonal2)) {
                continue;
            }
            queens[rowIndex] = i;
            cols.add(i);
            diag1.add(diagonal1);
            diag2.add(diagonal2);
            backtrack(res, queens, n, cols, diag1, diag2, rowIndex + 1);
            queens[rowIndex] = -1;
            cols.remove(i);
            diag1.remove(diagonal1);
            diag2.remove(diagonal2);
        }

    }

    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backtrack(res, queens, n, cols, diag1, diag2, 0);
        return res;
    }
}
