/**
 * @author sichu
 * @date 2022/12/02
 **/
public class Solution {
    public int secondHighest(String s) {
        int max1 = -1;
        int max2 = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num < max1 && num > max2) {
                    max2 = num;
                }
            }
        }
        return max2;
    }
}
