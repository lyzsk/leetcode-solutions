import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/05/27 14:59
 */
public class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLow = new int[26];
        int[] firstUp = new int[26];
        Arrays.fill(lastLow, -1);
        Arrays.fill(firstUp, -1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLow[c - 'a'] = i;
            } else {
                if (firstUp[c - 'A'] == -1) {
                    firstUp[c - 'A'] = i;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLow[i] != -1 && firstUp[i] != -1 && lastLow[i] < firstUp[i]) {
                res++;
            }
        }
        return res;
    }
}
