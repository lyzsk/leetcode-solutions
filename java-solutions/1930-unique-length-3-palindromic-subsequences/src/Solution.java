import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/01/04 11:48
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length(), res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int i = 0, j = n - 1;
            while (i < n && s.charAt(i) != c) {
                i++;
            }
            while (j >= 0 && s.charAt(j) != c) {
                j--;
            }
            if (j - i < 2) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            for (int k = i + 1; k < j; k++) {
                set.add(s.charAt(k));
            }
            res += set.size();
        }
        return res;
    }
}
