/**
 * @author sichu
 * @date 2023/02/20
 **/
public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < n && s.charAt(left--) == s.charAt(right++)) {
                    ++res;
                }
            }
        }
        return res;
    }
}
