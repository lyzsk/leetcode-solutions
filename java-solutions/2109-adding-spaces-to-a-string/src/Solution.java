/**
 * @author sichu huang
 * @since 2024/12/03 17:58
 */
public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int n = s.length(), m = spaces.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (j < m && spaces[j] == i) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
