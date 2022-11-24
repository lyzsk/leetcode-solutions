/**
 * @author sichu
 * @date 2022/11/24
 **/
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return countWithMergeSort(nums, 0, n - 1);
    }

    private int countWithMergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftCount = countWithMergeSort(nums, left, mid);
        int rightCount = countWithMergeSort(nums, mid + 1, right);
        int mergeCount = merge(nums, left, mid, right);
        return leftCount + rightCount + mergeCount;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int res = 0;
        int curLeft = left;
        int curRight = mid + 1;
        int ptr = 0;
        // merge 前先计算 (l, r) pair是否满足条件
        int l = left;
        int r = mid + 1;
        while (curLeft <= mid) {
            while (r <= right && (long)nums[curLeft] > 2 * (long)nums[r]) {
                ++r;
            }
            res += r - mid - 1;
            ++curLeft;
        }
        // merge
        int[] temp = new int[right - left + 1];
        curLeft = left;
        curRight = mid + 1;
        while (curLeft <= mid && curRight <= right) {
            if (nums[curLeft] <= nums[curRight]) {
                temp[ptr++] = nums[curLeft++];
            } else {
                temp[ptr++] = nums[curRight++];
            }
        }
        while (curLeft <= mid) {
            temp[ptr++] = nums[curLeft++];
        }
        while (curRight <= right) {
            temp[ptr++] = nums[curRight++];
        }
        ptr = 0;
        while (left <= right) {
            nums[left++] = temp[ptr++];
        }
        return res;
    }
}
