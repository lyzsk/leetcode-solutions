import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/04/20
 **/
public class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 || (i > 0 && land[i - 1][j] == 1) || (j > 0 && land[i][j - 1] == 1)) {
                    continue;
                }
                int endRow = i;
                int endCol = j;
                while (endRow + 1 < m && land[endRow + 1][endCol] == 1) {
                    ++endRow;
                }
                while (endCol + 1 < n && land[endRow][endCol + 1] == 1) {
                    ++endCol;
                }
                list.add(new int[] {i, j, endRow, endCol});
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
