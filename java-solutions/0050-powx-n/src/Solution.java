/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulti(x, N) : 1.0 / quickMulti(x, -N);
    }

    private double quickMulti(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMulti(x, N >> 1);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
