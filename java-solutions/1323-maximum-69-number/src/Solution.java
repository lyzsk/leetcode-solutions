/**
 * @author sichu huang
 * @since 2025/08/17 01:09
 */
public class Solution {
    public int maximum69Number(int num) {
        int digitBase = (int)Math.pow(10, (int)Math.log10(num));
        while (digitBase > 0) {
            if ((num / digitBase) % 10 == 6) {
                num += 3 * digitBase;
                return num;
            }
            digitBase /= 10;
        }

        return num;
    }
}
