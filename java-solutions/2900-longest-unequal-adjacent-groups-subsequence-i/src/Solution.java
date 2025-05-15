import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/05/15 08:43
 */
public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
