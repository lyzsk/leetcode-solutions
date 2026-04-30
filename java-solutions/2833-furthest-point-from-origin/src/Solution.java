/**
 *
 * @author sichu huang
 * @since 2026/04/24 18:04
 */
public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, B = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'R') {
                R++;
            } else {
                B++;
            }
        }
        return Math.abs(L - R) + B;
    }
}
