/**
 * @author sichu
 * @date 2023/01/02
 **/
public class Solution {
    public boolean areNumbersAscending(String s) {
        int i = 0;
        int pre = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int cur = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    cur = cur * 10 + s.charAt(i) - '0';
                    ++i;
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            } else {
                ++i;
            }
        }
        return true;
    }
}
