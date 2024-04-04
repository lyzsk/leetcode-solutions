/**
 * @author sichu huang
 * @date 2024/04/04
 **/
public class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++size;
                res = Math.max(res, size);
            } else if (ch == ')') {
                --size;
            }
        }
        return res;
    }
}
