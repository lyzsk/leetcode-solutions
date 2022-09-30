/**
 * @author sichu
 * @date 2022/09/30
 **/
public class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch == ' ' || ch == '-') {
                continue;
            }
            sb.append(ch);
            ++count;
            if (count % 3 == 0) {
                sb.append('-');
                count = 0;
            }
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (count == 1 && sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length() - 2, '-');
        }
        return sb.toString();
    }
}
