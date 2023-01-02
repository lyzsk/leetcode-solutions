/**
 * @author sichu
 * @date 2023/01/02
 **/
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(1)) ^ Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
