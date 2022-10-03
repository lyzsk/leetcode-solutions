/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    private static void reverse(int[] nums, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
}
