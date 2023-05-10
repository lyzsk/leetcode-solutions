/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        // int left = 0;
        // int right = nums.length - 1;
        // while (left <= right) {
        //     if (nums[left] == val) {
        //         nums[left] = nums[right--];
        //     } else {
        //         ++left;
        //     }
        // }
        // return left;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                ++left;
            }
        }
        return left;
    }
}
