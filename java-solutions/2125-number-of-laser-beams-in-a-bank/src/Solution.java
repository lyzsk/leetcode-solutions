/**
 * @author sichu
 * @date 2024/01/03
 **/
public class Solution {
    public int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int res = 0;
        for (String row : bank) {
            int curRowCount = helper(row);
            if (curRowCount == 0) {
                continue;
            }
            res += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return res;
    }

    private int helper(String row) {
        int res = 0;
        for (char ch : row.toCharArray()) {
            res += ch - '0';
        }
        return res;
    }
}
