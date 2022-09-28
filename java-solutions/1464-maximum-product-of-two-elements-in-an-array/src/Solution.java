/**
 * @author sichu
 * @date 2022/08/25
 **/
public class Solution {
    public int maxProduct(int[] nums) {
        int first = nums[0];
        int second = nums[1];
        if (first < second) {
            int temp = first;
            first = second;
            second = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}
