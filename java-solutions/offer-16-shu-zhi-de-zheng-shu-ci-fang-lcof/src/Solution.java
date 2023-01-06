/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulti(x, n) : 1.0 / quickMulti(x, -n);
    }

    private double quickMulti(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMulti(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
