/**
 * @author sichu huang
 * @date 2024/03/05
 **/
public class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);
            while (left <= right && s.charAt(left) == ch) {
                ++left;
            }
            while (left <= right && s.charAt(right) == ch) {
                --right;
            }
        }
        return right - left + 1;
    }
}
