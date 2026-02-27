import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2026/02/23 14:54
 */
public class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        int num = Integer.parseInt(s.substring(0, k), 2);
        Set<Integer> exists = new HashSet<>();
        exists.add(num);
        for (int i = 1; i + k <= s.length(); ++i) {
            num = (num - ((s.charAt(i - 1) - '0') << (k - 1))) * 2 + (s.charAt(i + k - 1) - '0');
            exists.add(num);
        }
        return exists.size() == (1 << k);
    }
}
