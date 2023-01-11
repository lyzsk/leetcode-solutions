/**
 * @author sichu
 * @date 2023/01/11
 **/
public class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] hash = new int[10];
        for (char ch : num.toCharArray()) {
            int digit = ch - '0';
            ++hash[digit];
        }
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            if (hash[i] != digit) {
                return false;
            }
        }
        return true;
    }
}
