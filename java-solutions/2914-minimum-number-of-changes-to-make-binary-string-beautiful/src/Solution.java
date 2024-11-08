/**
 * @author sichu huang
 * @since 2024/11/05 19:44
 */
public class Solution {
    public int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }
}
