/**
 * 二分查找 [1, maxSum] 范围内满足条件的 数组和 (mid) 值
 * 退出二分查找循环后 left 代表数组和恰好大于maxSum时的数组和
 * <p>
 * getPartSum 里,
 * 如果 maxSum > count, 说明最多减到 maxSum - count,
 * 等差数列求和: ((maxSum - count) + (maxSum - 1)) * count / 2 = count * (2 * maxSum - 1 - count) / 2
 * 如果 maxSum <= count, 说明可以减到 1, 在 [1, maxSum) 中一共 maxSum - 1 个数, 剩余 count - maxSum + 1 个 1
 * 求和: (maxSum - 1) * (1 + maxSum - 1) / 2 + count - maxSum + 1
 * = maxSum * (maxSum - 1) / 2 + count - maxSum + 1
 *
 * @author sichu
 * @date 2023/01/04
 **/
public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int leftCount = index;
        int rightCount = n - 1 - index;
        int left = 1;
        int right = maxSum;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long sum = mid + getPartSum(mid, leftCount) + getPartSum(mid, rightCount);
            if (sum > maxSum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private long getPartSum(int maxSum, int count) {
        if (maxSum > count) {
            return (long)count * (2L * maxSum - count - 1) / 2;
        } else {
            return (long)maxSum * (maxSum - 1) / 2 + count - maxSum + 1;
        }
    }
}
