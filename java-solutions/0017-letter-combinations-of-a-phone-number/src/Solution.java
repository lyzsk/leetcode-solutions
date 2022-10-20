import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    private static final String[] LETTERMAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static void backtrack(List<String> res, StringBuilder path, String digits, int startIndex) {
        if (startIndex == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = LETTERMAP[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(res, path, digits, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        backtrack(res, path, digits, 0);
        return res;
    }
}
