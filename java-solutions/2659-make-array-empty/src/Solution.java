import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu
 * @date 2023/05/11
 **/
public class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, Comparator.comparingInt(i -> nums[i]));
        long res = n;
        // [1, ...]
        BIT bit = new BIT(n + 1);
        // 上一个删除位置, 从1开始
        int pre = 1;
        for (int i = 0; i < n; i++) {
            // 下标从1开始
            int ptr = idxs[i] + 1;
            if (ptr >= pre) {
                res += ptr - pre - bit.query(pre, ptr);
            } else {
                res += n - pre + ptr - i + bit.query(ptr, pre - 1);
            }
            // 删除ptr
            bit.inc(ptr);
            pre = ptr;
        }
        return res;
    }
}

class BIT {
    private final int[] TREE;

    public BIT(int n) {
        TREE = new int[n];
    }

    public void inc(int i) {
        while (i < TREE.length) {
            ++TREE[i];
            i += lowbit(i);
        }
    }

    public int query(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += TREE[index];
            index -= lowbit(index);
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & -x;
    }
}