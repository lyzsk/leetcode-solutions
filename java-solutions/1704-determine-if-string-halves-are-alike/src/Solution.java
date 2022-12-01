/**
 * @author sichu
 * @date 2022/12/01
 **/
public class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() >> 1) {
                cnt1 += vowels.indexOf(ch) >= 0 ? 1 : 0;
            } else {
                cnt2 += vowels.indexOf(ch) >= 0 ? 1 : 0;
            }
        }
        return cnt1 == cnt2;
    }
}
