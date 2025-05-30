import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/05/24 10:26
 */
public class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
