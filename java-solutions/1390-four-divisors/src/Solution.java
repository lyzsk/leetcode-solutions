/**
 * @author sichu huang
 * @since 2026/01/04 17:24
 */
public class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int factor_cnt = 0, factor_sum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    ++factor_cnt;
                    factor_sum += i;
                    if (i * i != num) {
                        ++factor_cnt;
                        factor_sum += num / i;
                    }
                }
            }
            if (factor_cnt == 4) {
                res += factor_sum;
            }
        }
        return res;
    }
}
