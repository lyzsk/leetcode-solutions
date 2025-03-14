/**
 * @author sichu huang
 * @since 2025/03/11 16:14
 */
public class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0, left = 0;
        int[] charCount = new int[3];
        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'a']++;
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                cnt += s.length() - right;
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return cnt;
    }
}
