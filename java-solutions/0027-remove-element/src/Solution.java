/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        // int n = nums.length;
        // int left = 0;
        // for (int right = 0; right < n; right++) {
        //     if (nums[right] != val) {
        //         nums[left++] = nums[right];
        //     }
        // }
        // return left;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                --right;
            } else {
                ++left;
            }
        }
        return left;
    }
}
