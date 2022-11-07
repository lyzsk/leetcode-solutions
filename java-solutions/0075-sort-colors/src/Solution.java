/**
 * @author sichu
 * @date 2022/11/07
 **/
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int idx = 0;
        while (idx <= right) {
            if (nums[idx] == 0) {
                swap(nums, left++, idx++);
            } else if (nums[idx] == 1) {
                idx++;
            } else {
                swap(nums, idx, right--);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
