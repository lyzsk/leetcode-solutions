/**
 * @author sichu
 * @date 2023/01/05
 **/
public class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0) {
                ++res;
            }
        }
        return res;
    }
}
