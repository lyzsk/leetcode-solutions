/**
 * @author sichu
 * @date 2022/11/20
 **/
public class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int ptr = 0;
        int last = 0;
        int res = 0;
        while (ptr < n) {
            char ch = s.charAt(ptr);
            int cnt = 0;
            while (ptr < n && s.charAt(ptr) == ch) {
                ++ptr;
                ++cnt;
            }
            res += Math.min(cnt, last);
            last = cnt;
        }
        return res;
    }
}
