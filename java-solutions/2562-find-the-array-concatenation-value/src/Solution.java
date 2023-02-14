/**
 * @author sichu
 * @date 2023/02/13
 **/
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            res += Integer.parseInt(nums[left++] + "" + nums[right--]);
        }
        return (left == right ? nums[left] : 0) + res;
    }
}
