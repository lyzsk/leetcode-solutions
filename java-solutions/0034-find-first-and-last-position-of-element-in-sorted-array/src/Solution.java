/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        for (int i = 0; i < 2; i++) {
            int left = res[0] == -1 ? 0 : res[0];
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target == nums[mid]) {
                    res[i] = mid;
                    if (i == 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
