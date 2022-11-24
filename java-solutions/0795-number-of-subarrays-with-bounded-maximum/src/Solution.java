/**
 * @author sichu
 * @date 2022/11/24
 **/
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int lower) {
        int res = 0;
        int cur = 0;
        for (int num : nums) {
            cur = num <= lower ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}
