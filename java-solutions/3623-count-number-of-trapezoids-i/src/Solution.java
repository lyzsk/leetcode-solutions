import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/12/03 00:27
 */
public class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> pointNum = new HashMap<>();
        final int mod = 1000000007;
        long res = 0, sum = 0;
        for (int[] point : points) {
            pointNum.put(point[1], pointNum.getOrDefault(point[1], 0) + 1);
        }
        for (int pNum : pointNum.values()) {
            long edge = (long)pNum * (pNum - 1) / 2;
            res = (res + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }
        return (int)res;
    }
}
