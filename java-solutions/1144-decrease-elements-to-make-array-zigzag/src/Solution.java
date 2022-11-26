/**
 * @author sichu
 * @date 2022/11/26
 **/
public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        // 每个even索引都大于相邻元素, 每个odd索引都小于相邻元素
        // 或每个odd索引都大于相邻元素, 每个even索引都小于相邻元素
        int n = nums.length;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1 >= 0 ? nums[i - 1] : nums[i] + 1;
            int r = i + 1 < n ? nums[i + 1] : nums[i] + 1;
            int min = Math.min(l, r);
            if (i % 2 == 0) {
                if (nums[i] >= min) {
                    even += nums[i] - min + 1;
                }
            } else {
                if (nums[i] >= min) {
                    odd += nums[i] - min + 1;
                }
            }
        }
        return Math.min(even, odd);
    }
}
