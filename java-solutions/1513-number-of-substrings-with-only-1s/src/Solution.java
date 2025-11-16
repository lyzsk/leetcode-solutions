/**
 * @author sichu huang
 * @since 2025/11/16 15:58
 */
public class Solution {
    public int numSub(String s) {
        final int MOD = (int)(1e9 + 7);
        long total = 0;
        int length = s.length();
        long consecutive = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                total += consecutive * (consecutive + 1) / 2;
                total %= MOD;
                consecutive = 0;
            } else {
                consecutive++;
            }
        }
        total += consecutive * (consecutive + 1) / 2;
        total %= MOD;
        return (int)total;
    }
}
