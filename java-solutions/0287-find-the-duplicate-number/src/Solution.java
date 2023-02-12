/**
 * @author sichu
 * @date 2023/02/12
 **/
public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int target = nums[i];
            int idx = target - 1;
            if (nums[idx] == target) {
                if (idx != i) {
                    return target;
                }
                ++i;
            } else {
                swap(nums, idx, i);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
