/**
 * @author sichu
 * @date 2023/02/11
 **/
public class Solution {
    public String alphabetBoardPath(String target) {
        int row = 0;
        int col = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int tRow = (ch - 'a') / 5;
            int tCol = (ch - 'a') % 5;
            if (tRow < row) {
                for (int j = 0; j < row - tRow; j++) {
                    res.append("U");
                }
            }
            if (tCol < col) {
                for (int j = 0; j < col - tCol; j++) {
                    res.append("L");
                }
            }
            if (tRow > row) {
                for (int j = 0; j < tRow - row; j++) {
                    res.append("D");
                }
            }
            if (tCol > col) {
                for (int j = 0; j < tCol - col; j++) {
                    res.append("R");
                }
            }
            res.append("!");
            row = tRow;
            col = tCol;
        }
        return res.toString();
    }
}
