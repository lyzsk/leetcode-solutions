/**
 * @author sichu
 * @date 2022/10/23
 **/
public class Solution {
    /**
     * public int searchInsert(int[] nums, int target) {
     * int left = 0;
     * int right = nums.length - 1;
     * int res = nums.length;
     * while (left <= right) {
     * int mid = left + ((right - left) >> 1);
     * if (target == nums[mid]) {
     * return mid;
     * } else if (target < nums[mid]) {
     * right = mid - 1;
     * } else {
     * left = mid + 1;
     * }
     * }
     * return left;
     * }
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == n - 1 && nums[left] < target) {
            return n;
        }
        return left;
    }
}
