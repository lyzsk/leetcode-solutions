/**
 * @author sichu huang
 * @since 2025/09/09 00:03
 */
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[] {A, B};
            }
        }
        return new int[0];
    }
}
