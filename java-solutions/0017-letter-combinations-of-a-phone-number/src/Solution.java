import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    private final String[] LETTERMAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if (digits == null || n == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        backtrack(res, digits, path, 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, StringBuilder path, int startIndex) {
        if (startIndex < 0 || startIndex > digits.length()) {
            return;
        }
        if (startIndex == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = LETTERMAP[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(res, digits, path, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
