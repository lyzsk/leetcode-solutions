/**
 * @author sichu
 * @date 2022/10/04
 **/
public class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            cnt += ch == '(' ? 1 : -1;
            if (cnt < 0) {
                cnt = 0;
                ++res;
            }
        }
        return res + cnt;
    }
}
