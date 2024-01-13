/**
 * @author sichu
 * @date 2024/01/13
 **/
public class Solution {
    public int minSteps(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for (char ch : s.toCharArray()) {
            ++cntS[ch - 'a'];
        }
        for (char ch : t.toCharArray()) {
            ++cntT[ch - 'a'];
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(cntS[i] - cntT[i]);
        }
        return res >> 1;
    }
}
