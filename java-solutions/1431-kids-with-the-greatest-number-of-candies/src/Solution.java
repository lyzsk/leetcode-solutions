import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/04/17
 **/
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(candies[i] + extraCandies >= maxCandies);
        }
        return res;
    }
}
