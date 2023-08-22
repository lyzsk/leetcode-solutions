/**
 * @author sichu
 * @date 2023/08/22
 **/
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
