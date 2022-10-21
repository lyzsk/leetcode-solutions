import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        return backtrack(n, cols, diag1, diag2, 0);
    }

    private int backtrack(int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, int rowIndex) {
        if (rowIndex == n) {
            return 1;
        } else {
            int cnt = 0;
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
                cols.add(i);
                diag1.add(diagonal1);
                diag2.add(diagonal2);
                cnt += backtrack(n, cols, diag1, diag2, rowIndex + 1);
                cols.remove(i);
                diag1.remove(diagonal1);
                diag2.remove(diagonal2);
            }
            return cnt;
        }
    }
}
