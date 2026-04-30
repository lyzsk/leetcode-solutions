import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/04/22 17:50
 */
public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int dis = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        dis++;
                    }
                }
                if (dis <= 2) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }
}
