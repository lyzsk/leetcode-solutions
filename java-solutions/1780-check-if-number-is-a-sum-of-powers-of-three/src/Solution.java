/**
 * @author sichu
 * @date 2022/12/09
 **/
public class Solution {
    public boolean checkPowersOfThree(int n) {
        //    3^0 = 1, 3^1 = 3, 3^2 = 9
        //    1 % 3 == 1, 2 % 3 == 2, 3 % 3 == 0, 4 % 3 == 1, 5 % 3 == 2, 6 % 3 == 0
        if (n == 0) {
            return false;
        }
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
