/**
 * @author sichu
 * @date 2022/09/28
 **/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (res == right) {
                ++res;
            }
        }
        return res;
    }
}
