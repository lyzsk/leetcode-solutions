/**
 * @author sichu
 * @date 2023/12/31
 **/
public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int res = -1;
        for (int left = 0; left < n; left++) {
            for (int right = left + 1; right < n; right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    res = Math.max(res, right - left - 1);
                }
            }
        }
        return res;
    }
}
