/**
 * @author sichu huang
 * @date 2024/07/30
 **/
public class Solution {
    public int minimumDeletions(String s) {
        int leftb = 0;
        int righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                ++righta;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                --righta;
            } else {
                ++leftb;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }
}
