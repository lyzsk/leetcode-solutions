import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/11/23 15:01
 */
public class Solution {
    private static final char STONE = '#', OBSTACLE = '*', EMPTY = '.';

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] rotated = new char[n][m];
        for (int j = 0; j < n; j++) {
            Arrays.fill(rotated[j], EMPTY);
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1, k = n - 1; j >= 0; j--) {
                if (box[i][j] == STONE) {
                    rotated[k][m - i - 1] = STONE;
                    k--;
                } else if (box[i][j] == OBSTACLE) {
                    rotated[j][m - i - 1] = OBSTACLE;
                    k = j - 1;
                }
            }
        }
        return rotated;
    }
}
