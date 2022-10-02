/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i - 2], b = f[i - 1], c = f[i]
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
