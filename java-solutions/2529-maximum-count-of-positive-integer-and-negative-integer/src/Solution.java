/**
 * > 0 个数,
 * < 0 个数,
 * 边界 left <= right
 *
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public int maximumCount(int[] nums) {
        int negCnt = binarySearch(nums, 0);
        int posCnt = nums.length - binarySearch(nums, 1);
        return Math.max(negCnt, posCnt);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
