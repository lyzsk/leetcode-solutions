/**
 * 情况1: i != j, (i | j) & k = (j | i) & k
 * 情况2: i == j, (i | i) & k
 * 情况3: i == j == k, i & i = 0
 * 情况4: i != j == k,
 * 情况5: i == j == k, = 0
 *
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
