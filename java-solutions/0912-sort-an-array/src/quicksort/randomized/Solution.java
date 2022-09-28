package quicksort.randomized;

import java.util.Random;

/**
 * @author sichu
 * @date 2022/08/16
 **/
public class Solution {
    private static void quickSelect(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = randomPartition(nums, left, right);
        if (pos < right) {
            quickSelect(nums, pos + 1, right);
        }
        if (pos > left) {
            quickSelect(nums, left, pos - 1);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int[] sortArray(int[] nums) {
        quickSelect(nums, 0, nums.length - 1);
        return nums;
    }
}
