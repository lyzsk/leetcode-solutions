import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/06/06
 **/
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }
}
