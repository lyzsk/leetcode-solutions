import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left--];
            } else {
                nums[i] = clone[right--];
            }
        }
    }
}
