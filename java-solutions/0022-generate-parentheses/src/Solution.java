import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    private static void backtrack(List<String> res, StringBuilder path, int n, int leftCount, int rightCount) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (leftCount < n) {
            path.append("(");
            backtrack(res, path, n, leftCount + 1, rightCount);
            path.deleteCharAt(path.length() - 1);
        }
        if (rightCount < leftCount) {
            path.append(")");
            backtrack(res, path, n, leftCount, rightCount + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(res, path, n, 0, 0);
        return res;
    }
}
