/**
 * @author sichu huang
 * @since 2024/11/01 19:34
 */
public class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        int n = s.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == res.charAt(res.length() - 1)) {
                cnt++;
                if (cnt < 3) {
                    res.append(s.charAt(i));
                }
            } else {
                cnt = 1;
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
