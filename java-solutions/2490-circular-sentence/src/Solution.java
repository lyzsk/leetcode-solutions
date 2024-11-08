/**
 * @author sichu huang
 * @since 2024/11/02 20:05
 */
public class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
