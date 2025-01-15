/**
 * @author sichu huang
 * @since 2025/01/11 11:46
 */
public class Solution {
    public boolean canConstruct(String s, int k) {
        int right = s.length();
        int[] occ = new int[26];
        for (int i = 0; i < right; ++i) {
            ++occ[s.charAt(i) - 'a'];
        }
        int left = 0;
        for (int i = 0; i < 26; ++i) {
            if (occ[i] % 2 == 1) {
                ++left;
            }
        }
        left = Math.max(left, 1);
        return left <= k && k <= right;
    }
}
