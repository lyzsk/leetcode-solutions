import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/12/22 23:47
 */
public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> seen = new HashSet<>();
        boolean hasCycle = false;
        int cycleLength = 0;
        for (int i = 0; i < n; i++) {
            int[] next = new int[8];
            for (int j = 1; j < 7; j++) {
                next[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
            }
            String state = Arrays.toString(next);
            if (seen.contains(state)) {
                hasCycle = true;
                break;
            } else {
                seen.add(state);
                cycleLength++;
            }
            cells = next;
        }
        if (hasCycle) {
            n = n % cycleLength;
            return prisonAfterNDays(cells, n);
        }
        return cells;
    }
}
