/**
 * @author sichu huang
 * @date 2024/03/30
 **/
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] num1 = new int[n + 1];
        int[] num2 = new int[n + 1];
        int total1 = 0;
        int total2 = 0;
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            if (num1[nums[right]] == 0) {
                ++total1;
            }
            ++num1[nums[right]];
            if (num2[nums[right]] == 0) {
                ++total2;
            }
            ++num2[nums[right]];
            while (total1 > k) {
                --num1[nums[left1]];
                if (num1[nums[left1]] == 0) {
                    --total1;
                }
                ++left1;
            }
            while (total2 > k - 1) {
                --num2[nums[left2]];
                if (num2[nums[left2]] == 0) {
                    --total2;
                }
                ++left2;
            }
            res += left2 - left1;
            ++right;
        }
        return res;
    }
}
