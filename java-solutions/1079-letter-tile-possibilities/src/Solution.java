import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/05/19
 **/
public class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Map<Character, Integer> cnt = new HashMap<>(16);
        for (char ch : tiles.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(cnt.keySet());
        return dfs(n, cnt, tile) - 1;
    }

    private int dfs(int n, Map<Character, Integer> cnt, Set<Character> tile) {
        int res = 1;
        if (n == 0) {
            return res;
        }
        for (char ch : tile) {
            if (cnt.get(ch) > 0) {
                cnt.put(ch, cnt.get(ch) - 1);
                res += dfs(n - 1, cnt, tile);
                cnt.put(ch, cnt.get(ch) + 1);
            }
        }
        return res;
    }
}
