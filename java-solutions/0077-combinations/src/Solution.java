import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    private void backtrack(List<List<Integer>> res, Deque<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtrack(res, path, n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, n, k, 1);
        return res;
    }
}
