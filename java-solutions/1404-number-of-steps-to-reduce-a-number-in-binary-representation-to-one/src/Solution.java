/**
 * @author sichu huang
 * @date 2024/05/29
 **/
public class Solution {
    public int numSteps(String s) {
        int res = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res += 2;
            } else {
                res += 1;
            }
        }
        return res + carry;
    }
}
