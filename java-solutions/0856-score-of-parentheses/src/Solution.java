/**
 * @author sichu
 * @date 2022/10/09
 **/
public class Solution {
    public int scoreOfParentheses(String s) {
        int bal = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }
}
