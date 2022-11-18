import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/11/18
 **/
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int res = 2001;
        for (int x : fronts) {
            if (!set.contains(x)) {
                res = Math.min(res, x);
            }
        }
        for (int x : backs) {
            if (!set.contains(x)) {
                res = Math.min(res, x);
            }
        }
        return res == 2001 ? 0 : res;
    }
}
