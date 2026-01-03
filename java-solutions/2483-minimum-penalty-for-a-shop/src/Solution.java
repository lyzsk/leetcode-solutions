/**
 * @author sichu huang
 * @since 2025/12/26 17:19
 */
public class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0, best_penalty = 0, res = 0;
        char[] ch = customers.toCharArray();
        for (int i = 0; i < customers.length(); i++) {
            if (ch[i] == 'Y') {
                penalty--;
                if (penalty < best_penalty) {
                    best_penalty = penalty;
                    res = i + 1;
                }
            } else {
                penalty++;
            }
        }
        return res;
    }
}
