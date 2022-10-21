import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    private static void backtrack(List<String> res, Deque<String> path, String s, List<String> wordDict,
        int startIndex) {
        if (startIndex == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (String word : wordDict) {
            if (s.indexOf(word, startIndex) == startIndex) {
                path.addLast(word);
                backtrack(res, path, s, wordDict, startIndex + word.length());
                path.removeLast();
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backtrack(res, path, s, wordDict, 0);
        return res;
    }
}
