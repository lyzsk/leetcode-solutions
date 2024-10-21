/**
 * @author sichu huang
 * @since 2024/10/15 17:47
 **/
public class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                res += sum;
            }
        }
        return res;
    }
}
