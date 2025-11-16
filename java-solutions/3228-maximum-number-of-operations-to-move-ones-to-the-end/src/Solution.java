/**
 * @author sichu huang
 * @since 2025/11/13 11:47
 */
public class Solution {
    public int maxOperations(String s) {
        int countOne = 0;
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                res += countOne;
            } else {
                countOne++;
            }
            i++;
        }
        return res;
    }
}
