/**
 * @author sichu
 * @date 2022/11/29
 **/
public class Solution {
    public int minOperations(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int leadingZero = 0;
        int leadingOne = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch % 2 == i % 2) {
                ++leadingOne;
            } else {
                ++leadingZero;
            }
        }
        return Math.min(leadingOne, leadingZero);
    }
}
