import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/06/28
 **/
public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            ++degree[road[0]];
            ++degree[road[1]];
        }
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, (o1, o2) -> Integer.compare(degree[o2], degree[o1]));
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long)(n - i) * degree[cities[i]];
        }
        return res;
    }
}
