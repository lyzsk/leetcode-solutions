/**
 * @author sichu
 * @date 2022/12/26
 **/
public class Solution {
    public int minimumMoves(String s) {
        int res = 0;
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'X' && j > i) {
                ++res;
                i = j + 2;
            }
        }
        return res;
    }
}
