/**
 * @author sichu
 * @date 2022/11/23
 **/
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long[] presum = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        return countWithMergeSort(presum, lower, upper, 0, n - 1);
    }

    private int countWithMergeSort(long[] presum, int lower, int upper, int left, int right) {
        if (left == right) {
            return (presum[left] >= lower && presum[right] <= upper) ? 1 : 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftCount = countWithMergeSort(presum, lower, upper, left, mid);
        int rightCount = countWithMergeSort(presum, lower, upper, mid + 1, right);
        int mergeCount = merge(presum, lower, upper, left, mid, right);
        return leftCount + rightCount + mergeCount;
    }

    private int merge(long[] presum, int lower, int upper, int left, int mid, int right) {
        int res = 0;
        int curLeft = left;
        int curRight = mid + 1;
        int ptr = 0;
        // 在 merge 前 先计算[left, right] 区间内可能的 [l, r) 区间数量
        // 两个条件, >= lower, <= upper
        // l, r 的起点是右半部分的起点
        int l = mid + 1;
        int r = mid + 1;
        while (curLeft <= mid) {
            while (l <= right && presum[l] - presum[curLeft] < lower) {
                ++l;
            }
            while (r <= right && presum[r] - presum[curLeft] <= upper) {
                ++r;
            }
            // r 是边界的下一位
            res += r - l;
            ++curLeft;
        }
        // 得到 res 后开始朴素的 merge, 要记得把 curLeft 归位
        long[] temp = new long[right - left + 1];
        curLeft = left;
        curRight = mid + 1;
        while (curLeft <= mid && curRight <= right) {
            if (presum[curLeft] <= presum[curRight]) {
                temp[ptr++] = presum[curLeft++];
            } else {
                temp[ptr++] = presum[curRight++];
            }
        }
        while (curLeft <= mid) {
            temp[ptr++] = presum[curLeft++];
        }
        while (curRight <= right) {
            temp[ptr++] = presum[curRight++];
        }
        ptr = 0;
        while (left <= right) {
            presum[left++] = temp[ptr++];
        }
        return res;
    }
}
