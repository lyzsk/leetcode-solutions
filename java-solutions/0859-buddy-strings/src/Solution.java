/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);
            ++cnt1[ch1 - 'a'];
            ++cnt2[ch2 - 'a'];
            if (ch1 != ch2) {
                ++diff;
                if (diff > 2) {
                    return false;
                }
            }
        }
        boolean same = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                same = true;
            }
        }
        return diff == 2 || (diff == 0 && same);
    }
}
