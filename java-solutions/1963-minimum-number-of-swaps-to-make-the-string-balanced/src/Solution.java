/**
 * @author sichu huang
 * @date 2024/10/08
 **/
public class Solution {
    public int minSwaps(String s) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                ++cnt;
            } else {
                --cnt;
            }
            if (cnt < 0) {
                ++res;
                cnt += 2;
            }
        }
        return res;
    }
}
