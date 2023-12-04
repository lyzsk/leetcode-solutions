/**
 * @author sichu
 * @date 2023/12/04
 **/
public class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int res = -1;
        for (int i = 0; i + 2 < n; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                res = Math.max(res, num.charAt(i) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char)(res + 48));
        }
        return res == -1 ? "" : sb.toString();
    }
}
