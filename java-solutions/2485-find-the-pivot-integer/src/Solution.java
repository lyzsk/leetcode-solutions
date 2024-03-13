/**
 * @author sichu huang
 * @date 2024/03/13
 **/
public class Solution {
    public int pivotInteger(int n) {
        double x = Math.sqrt(n * (1 + n) / 2);
        if (x % 1 != 0) {
            return -1;
        } else {
            return (int)x;
        }
    }
}
