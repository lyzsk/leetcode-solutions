/**
 * @author sichu huang
 * @date 2024/06/22
 **/
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int res = 0;
        int temp = 0;
        for (int num : nums) {
            temp += num & 1;
            if (temp - k >= 0) {
                res += count[temp - k];
            }
            ++count[temp];
        }
        return res;
    }
}
