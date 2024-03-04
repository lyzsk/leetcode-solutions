import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/03/04
 **/
public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0;
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                ++score;
                ++left;
                res = Math.max(res, score);
            } else if (score > 0) {
                power += tokens[right];
                --score;
                --right;
            } else {
                break;
            }
        }
        return res;
    }
}
