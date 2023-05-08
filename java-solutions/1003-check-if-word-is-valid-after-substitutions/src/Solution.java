/**
 * @author sichu
 * @date 2023/05/08
 **/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("abc")) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.length() == 0;
    }
}
