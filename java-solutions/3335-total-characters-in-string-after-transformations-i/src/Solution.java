/**
 * @author sichu huang
 * @since 2025/05/13 18:42
 */
public class Solution {

    private static final int MOD = (int)(1e9 + 7);

    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            res = (res + cnt[i]) % MOD;
        }
        return res;
    }
}
