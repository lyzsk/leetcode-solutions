package quicksort.randomized;

import java.util.Random;

/**
 * @author sichu
 * @date 2022/08/16
 **/
public class Solution {
    private static int quickSelect(int[] nums, int left, int right, int index) {
        if (left >= right) {
            return nums[index];
        }
        int pos = randomPartition(nums, left, right);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSelect(nums, pos + 1, right, index) : quickSelect(nums, left, pos - 1, index);
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

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
}
