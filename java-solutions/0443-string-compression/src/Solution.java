/**
 * @author sichu
 * @date 2022/10/11
 **/
public class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int res = 0;
        while (idx < chars.length) {
            char cur = chars[idx];
            int cnt = 0;
            while (idx < chars.length && chars[idx] == cur) {
                ++idx;
                ++cnt;
            }
            chars[res++] = cur;
            if (cnt > 1) {
                // for (char digit : Integer.toString(cnt).toCharArray()) {
                //     chars[res++] = digit;
                // }
                if (cnt / 1000 > 0) {
                    chars[res++] = (char)(cnt / 1000 + '0');
                }
                if (cnt / 100 > 0) {
                    chars[res++] = (char)(cnt % 1000 / 100 + '0');
                }
                if (cnt / 10 > 0) {
                    chars[res++] = (char)(cnt % 100 / 10 + '0');
                }
                chars[res++] = (char)(cnt % 10 + '0');
            }
        }
        return res;
    }
}
