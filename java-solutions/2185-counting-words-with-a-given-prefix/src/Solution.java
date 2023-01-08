/**
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                ++res;
            }
        }
        return res;
    }
}
