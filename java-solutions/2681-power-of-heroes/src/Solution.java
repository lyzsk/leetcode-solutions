import java.util.Arrays;

/**
 * 贡献法: si = 2 * si-1 + ai-1
 *
 * @author sichu
 * @date 2023/08/01
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[] {2, 1, 4};
        int[] nums2 = new int[] {1, 1, 1};
        Solution solution = new Solution();
        // 141
        System.out.println(solution.subOfPower(nums1));
        // 7
        System.out.println(solution.subOfPower(nums2));
    }

    public int subOfPower(int[] nums) {
        final long MOD = (long)1e9 + 7;
        Arrays.sort(nums);

        long res = 0;
        long s = 0;
        for (long num : nums) {
            res = (res + ((num * num) % MOD) * ((num + s) % MOD)) % MOD;
            s = (2 * s + num) % MOD;
        }
        return (int)res;
    }
}
