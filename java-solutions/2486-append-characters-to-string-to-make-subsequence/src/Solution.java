/**
 * @author sichu huang
 * @date 2024/06/03
 **/
public class Solution {
    public int appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();
        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                ++tIndex;
            }
            ++sIndex;
        }
        return tLength - tIndex;
    }
}
