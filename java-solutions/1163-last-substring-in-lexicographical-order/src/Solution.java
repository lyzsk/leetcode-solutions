/**
 * @author sichu
 * @date 2023/04/24
 **/
public class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        for (int j = 1, k = 0; j + k < n; ) {
            int diff = s.charAt(i + k) - s.charAt(j + k);
            if (diff == 0) {
                ++k;
            } else if (diff < 0) {
                i += k + 1;
                k = 0;
                if (i >= j) {
                    j = i + 1;
                }
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
