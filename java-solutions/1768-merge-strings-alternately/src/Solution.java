/**
 * @author sichu
 * @date 2022/10/22
 **/
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int p1 = 0;
        int p2 = 0;
        StringBuilder res = new StringBuilder();
        while (p1 < m || p2 < n) {
            if (p1 < m) {
                res.append(word1.charAt(p1++));
            }
            if (p2 < n) {
                res.append(word2.charAt(p2++));
            }
        }
        return res.toString();
    }
}
