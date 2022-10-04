/**
 * @author sichu
 * @date 2022/10/04
 **/
public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        while (s.charAt(i) == ' ') {
            ++i;
            if (i == s.length()) {
                return 0;
            }
        }
        int sign = 1;
        int start = i;
        int res = 0;
        for (; i < s.length(); i++) {
            if (i == start && s.charAt(i) == '+') {
                sign = 1;
            } else if (i == start && s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int digit = s.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10
                    && -digit < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * digit;
            } else {
                break;
            }
        }
        return res;
    }
}
