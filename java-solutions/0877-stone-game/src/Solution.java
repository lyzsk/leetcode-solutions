/**
 *
 * @author sichu huang
 * @since 2026/08/02 13:20
 */
public class Solution {
    public boolean stoneGame(int[] piles) {
        Integer[][] memo = new Integer[piles.length][piles.length];
        return solve(piles, 0, piles.length - 1, memo) > 0;
    }

    private int solve(int[] piles, int left, int right, Integer[][] memo) {
        if (left == right) {
            return piles[left];
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int pickLeft = piles[left] - solve(piles, left + 1, right, memo);
        int pickRight = piles[right] - solve(piles, left, right - 1, memo);

        memo[left][right] = Math.max(pickLeft, pickRight);

        return memo[left][right];
    }
}
