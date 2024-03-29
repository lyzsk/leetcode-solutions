import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/02/03
 **/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int col = 0;
        int flag = -1;
        for (char ch : s.toCharArray()) {
            rows.get(col).append(ch);
            if (col == 0 || col == numRows - 1) {
                flag = -flag;
            }
            col += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
