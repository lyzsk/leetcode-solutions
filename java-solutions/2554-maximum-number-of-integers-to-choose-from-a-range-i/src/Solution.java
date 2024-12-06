import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2024/12/06 17:29
 */
public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
