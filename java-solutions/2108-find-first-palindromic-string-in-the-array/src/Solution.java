/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public String firstPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
