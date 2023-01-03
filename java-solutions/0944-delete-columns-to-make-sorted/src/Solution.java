/**
 * @author sichu
 * @date 2023/01/03
 **/
public class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int res = 0;
        if (strs.length == 1) {
            return res;
        }
        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}
