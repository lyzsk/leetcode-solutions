import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/06/10
 **/
public class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int res = 0;
        int[] expected = new int[n];
        System.arraycopy(heights, 0, expected, 0, n);
        Arrays.sort(expected);
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) {
                ++res;
            }
        }
        return res;
    }
}
