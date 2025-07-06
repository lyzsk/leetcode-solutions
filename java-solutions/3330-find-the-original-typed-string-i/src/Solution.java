/**
 * @author sichu huang
 * @since 2025/07/02 00:12
 */
public class Solution {
    public int possibleStringCount(String word) {
        int n = word.length(), res = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++res;
            }
        }
        return res;
    }
}
