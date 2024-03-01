/**
 * @author sichu
 * @date 2024/03/01
 **/
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cntOnes = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ++cntOnes;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (cntOnes > 1) {
                --cntOnes;
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        sb.append("1");
        return sb.toString();
    }
}
