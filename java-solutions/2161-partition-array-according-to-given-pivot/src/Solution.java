/**
 * @author sichu huang
 * @since 2025/03/03 11:23
 */
public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                res[left] = nums[i];
                left++;
            }
            if (nums[j] > pivot) {
                res[right] = nums[j];
                right--;
            }
        }
        while (left <= right) {
            res[left] = pivot;
            left++;
        }
        return res;
    }
}
