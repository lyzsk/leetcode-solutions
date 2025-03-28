import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2025/03/25 18:37
 */
public class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canCut(rectangles, 0) || canCut(rectangles, 1);
    }

    private boolean canCut(int[][] rectangles, int axis) {
        Arrays.sort(rectangles, Comparator.comparingInt(o -> o[axis]));
        int cuts = 0, previousEnd = -1;
        for (int[] rect : rectangles) {
            int start = rect[axis], end = rect[axis + 2];

            if (start >= previousEnd) {
                cuts++;
            }
            previousEnd = Math.max(previousEnd, end);
            if (cuts >= 3) {
                return true;
            }
        }
        return false;
    }
}
