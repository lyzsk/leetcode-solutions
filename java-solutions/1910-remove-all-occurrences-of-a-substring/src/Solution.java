/**
 * @author sichu huang
 * @since 2025/02/11 18:35
 */
public class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuffer sb = new StringBuffer();
        int n = s.length(), m = part.length();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            if (hasSuffix(sb, part)) {
                sb.setLength(sb.length() - m);
            }
        }
        return sb.toString();
    }

    private boolean hasSuffix(StringBuffer temp, String part) {
        if (temp.length() < part.length()) {
            return false;
        }
        for (int i = temp.length() - 1, j = part.length() - 1; j >= 0; i--, j--) {
            if (temp.charAt(i) != part.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
