import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2024/10/21 16:15
 */
public class Solution {
    int maxSplit = 1;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<String>();
        backtrack(0, 0, s, set);
        return maxSplit;
    }

    public void backtrack(int index, int split, String s, Set<String> set) {
        int length = s.length();
        if (index >= length) {
            maxSplit = Math.max(maxSplit, split);
        } else {
            for (int i = index; i < length; i++) {
                String substr = s.substring(index, i + 1);
                if (set.add(substr)) {
                    backtrack(i + 1, split + 1, s, set);
                    set.remove(substr);
                }
            }
        }
    }
}
