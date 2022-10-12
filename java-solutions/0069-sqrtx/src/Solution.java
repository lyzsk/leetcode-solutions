/**
 * @author sichu
 * @date 2022/10/12
 **/
public class Solution {
    public int mySqrt(int x) {
        // return (int)Math.pow(x, 0.5);
        if (x == 0) {
            return 0;
        }
        double c = x;
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(x0 - xi) < 1e-15) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
