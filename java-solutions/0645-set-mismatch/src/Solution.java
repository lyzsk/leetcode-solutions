/**
 * @author sichu
 * @date 2024/01/22
 **/
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicated = 0;
        int missing = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    ++cnt;
                }
            }
            if (cnt == 2) {
                duplicated = i;
            } else if (cnt == 0) {
                missing = i;
            }
        }
        return new int[] {duplicated, missing};
    }
}
