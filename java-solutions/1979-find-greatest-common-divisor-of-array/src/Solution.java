/**
 *
 * @author sichu huang
 * @since 2026/07/18 18:04
 */
public class Solution {
    public int findGCD(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        return gcd(mx, mn);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
