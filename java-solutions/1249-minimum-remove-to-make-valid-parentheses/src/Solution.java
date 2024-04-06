/**
 * @author sichu huang
 * @date 2024/04/06
 **/
public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++balance;
                sb.append(ch);
            } else if (ch == ')') {
                --balance;
                if (balance < 0) {
                    balance = 0;
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        int i = sb.length() - 1;
        while (balance != 0) {
            if (sb.charAt(i) == '(') {
                --balance;
                sb.deleteCharAt(i);
            }
            --i;
        }
        return sb.toString();
    }
}
