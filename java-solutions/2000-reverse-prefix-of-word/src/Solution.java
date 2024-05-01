/**
 * @author sichu huang
 * @date 2024/05/01
 **/
public class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            return new StringBuilder(word.substring(0, index + 1)).reverse() + word.substring(index + 1);
        }
        return word;
    }
}
