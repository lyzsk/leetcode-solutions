/**
 * @author sichu
 * @date 2022/12/26
 **/
public class Solution {
    public int countHomogenous(String s) {
        final int MOD = (int)(1e9 + 7);
        long res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(left) == s.charAt(right)) {
                res += right - left + 1;
            } else {
                res += 1;
                left = right;
            }
        }
        return (int)(res % MOD);
    }
}
