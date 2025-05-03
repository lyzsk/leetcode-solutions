import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/05/03 18:13
 */
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        set.add(tops[0]);
        set.add(bottoms[0]);
        for (Integer target : set) {
            int topSum = 0, bottomSum = 0;
            boolean flag = true;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != target && bottoms[i] != target) {
                    flag = false;
                    break;
                } else {
                    if (tops[i] == target) {
                        ++topSum;
                    }
                    if (bottoms[i] == target) {
                        ++bottomSum;
                    }
                }
            }
            if (flag) {
                int item = tops.length - Math.max(topSum, bottomSum);
                res = Math.min(res, item);
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
