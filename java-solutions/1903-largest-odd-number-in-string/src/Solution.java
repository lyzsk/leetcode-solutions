/**
 * @author sichu
 * @date 2023/12/07
 **/
public class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            int ch = num.charAt(i);
            if (ch % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
