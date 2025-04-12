/**
 * @author sichu huang
 * @since 2025/04/08 20:01
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] visited = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (visited[nums[i]]) {
                return i / 3 + 1;
            }
            visited[nums[i]] = true;
        }
        return 0;
    }
}
