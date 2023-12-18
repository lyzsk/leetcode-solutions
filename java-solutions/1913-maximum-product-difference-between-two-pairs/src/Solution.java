/**
 * @author sichu
 * @date 2023/12/18
 **/
public class Solution {
    public int maxProductDifference(int[] nums) {
        int w = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > w) {
                x = w;
                w = num;
            } else if (num > x) {
                x = num;
            }

            if (num < y) {
                z = y;
                y = num;
            } else if (num < z) {
                z = num;
            }
        }
        return w * x - y * z;
    }
}
