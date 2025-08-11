import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/07/31 16:13
 */
public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : arr) {
            Set<Integer> cur2 = new HashSet();
            for (int y : cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            res.addAll(cur);
        }

        return res.size();
    }
}
