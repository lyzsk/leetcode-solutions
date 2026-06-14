/**
 *
 * @author sichu huang
 * @since 2026/06/13 18:48
 */
public class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder(words.length);
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                s += weights[word.charAt(i) - 'a'];
            }
            res.append((char)('z' - s % 26));
        }
        return res.toString();
    }
}
