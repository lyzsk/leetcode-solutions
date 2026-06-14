import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sichu huang
 * @since 2026/05/26 12:47
 */
public class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet<>();
        for (char c : word.toCharArray()) {
            s.add(c);
        }
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.contains(c) && s.contains((char)(c - 'a' + 'A'))) {
                res++;
            }
        }
        return res;
    }
}
