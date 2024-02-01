import java.util.Arrays;

/**
 * @author sichu
 * @date 2024/02/01
 **/
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        Arrays.sort(nums);
        int idx = 0;
        for (int i = 0; i < n; i += 3) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (third - first <= k) {
                res[idx][0] = first;
                res[idx][1] = second;
                res[idx][2] = third;
                ++idx;
            } else {
                return new int[0][0];
            }
        }
        return res;
    }
}
