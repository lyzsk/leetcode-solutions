/**
 * @author sichu
 * @date 2022/12/26
 **/
public class Solution {
    public int countHomogenous(String s) {
        final int MOD = (int)(1e9 + 7);
        long res = 0;
        char prev = s.charAt(0);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == prev) {
                ++cnt;
            } else {
                res += (long)cnt * (cnt + 1) / 2;
                cnt = 1;
                prev = ch;
            }
        }
        res += (long)cnt * (cnt + 1) / 2;
        return (int)(res % MOD);
    }
}
