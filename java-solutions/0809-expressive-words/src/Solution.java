/**
 * @author sichu
 * @date 2022/11/24
 **/
public class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (check(s, word)) {
                ++res;
            }
        }
        return res;
    }

    private boolean check(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0;
            int cntj = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                ++cnti;
                ++i;
            }
            while (j < word.length() && word.charAt(j) == ch) {
                ++cntj;
                ++j;
            }
            if (cnti < cntj || (cnti > cntj && cnti < 3)) {
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }
}
