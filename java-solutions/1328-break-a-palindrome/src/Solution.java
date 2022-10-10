/**
 * @author sichu
 * @date 2022/10/10
 **/
public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        for (int i = 0; i < (palindrome.length() >> 1); i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i).concat("a").concat(palindrome.substring(i + 1));
            }
        }
        return palindrome.substring(0, palindrome.length() - 1).concat("b");
    }
}
