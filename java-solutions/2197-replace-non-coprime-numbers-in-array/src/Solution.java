import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/09/17 01:31
 */
public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            while (!res.isEmpty()) {
                int last = res.get(res.size() - 1);
                int g = gcd(last, num);
                if (g > 1) {
                    num = last / g * num;
                    res.remove(res.size() - 1);
                } else {
                    break;
                }
            }
            res.add(num);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
