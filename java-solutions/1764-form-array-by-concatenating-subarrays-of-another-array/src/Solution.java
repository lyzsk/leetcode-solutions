/**
 * @author sichu
 * @date 2022/12/16
 **/
public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length && i < groups.length; ) {
            if (check(groups[i], nums, j)) {
                j += groups[i].length;
                ++i;
            } else {
                ++j;
            }
        }
        return i == groups.length;
    }

    private boolean check(int[] group, int[] nums, int j) {
        if (j + group.length > nums.length) {
            return false;
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[i + j]) {
                return false;
            }
        }
        return true;
    }
}
