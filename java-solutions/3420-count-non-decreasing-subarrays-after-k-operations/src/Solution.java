import java.util.*;

/**
 *
 * @author sichu huang
 * @since 2026/11/13
 */
public class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        long operations = 0;
        // 优先队列维护窗口最大值
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 记录被该下标覆盖的元素集合
        List<List<Integer>> cnt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt.add(new ArrayList<>());
        }
        // 右侧第一个大于等于的下标
        int[] pos = new int[n];
        Arrays.fill(pos, n);
        // 递减单调栈
        Deque<Integer> st = new ArrayDeque<>();

        for (int left = 0, right = 0; right < n; right++) {
            // 维护单调栈
            while (!st.isEmpty() && nums[right] >= nums[st.peek()]) {
                pos[st.peek()] = right;
                st.pop();
            }
            // 栈顶即为 nums[right] 的左边最近的更大元素
            if (!st.isEmpty()) {
                cnt.get(st.peek()).add(right);
            }
            st.push(right);

            // 优先队首元素即为窗口最大值
            q.offer(new int[] {nums[right], right});
            // 窗口加入 nums[right] 操作次数需要增加
            operations += Math.max(0, q.peek()[0] - nums[right]);

            // 最小操作次数超过 k，此时需要缩小窗口
            while (operations > k) {
                // 移除窗口左侧元素 nums[left]，操作次数需要较少
                for (int i : cnt.get(left)) {
                    // 移除贡献
                    operations -= (long)(nums[left] - nums[i]) * (
                        Math.min(pos[i], right + 1) - i);
                }
                left++;
            }

            // 从优先队列中移除小于下标 left 的元素
            while (!q.isEmpty() && q.peek()[1] < left) {
                q.poll();
            }

            // 以 right 为结尾的合法连续子数组数目为 right - left + 1
            res += right - left + 1;
        }

        return res;
    }
}
