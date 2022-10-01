/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        if (n != end.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < n && end.charAt(j) == 'X') {
                ++j;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char ch = start.charAt(i);
                if ((ch == 'L' && i < j) || (ch == 'R' && i > j)) {
                    return false;
                }
                ++i;
                ++j;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            ++i;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            ++j;
        }
        return true;
    }
}
