/**
 * @author sichu huang
 * @since 2024/11/10 15:32
 */
public class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] sum = new int[31];
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int cnt = nums[0];
        addX(sum, nums[0]);
        if (nums[0] >= k) {
            return 1;
        }

        for (int i = 1; i < len; i++) {
            cnt = cnt | nums[i];
            addX(sum, nums[i]);
            while (cnt >= k) {
                res = Math.min(res, i - l + 1);
                cnt = delX(sum, nums[l]);
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void addX(int[] sum, int x) {
        char[] ch = Integer.toBinaryString(x).toCharArray();
        int len = ch.length;
        for (int i = len - 1; i >= 0; i--) {
            if (ch[i] == '1') {
                sum[30 - (len - 1 - i)]++;
            }
        }
    }

    public int delX(int[] sum, int x) {
        char[] ch = Integer.toBinaryString(x).toCharArray();
        int len = ch.length;
        for (int i = len - 1; i >= 0; i--) {
            if (ch[i] == '1') {
                sum[30 - (len - 1 - i)]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            if (sum[i] == 0) {
                sb = sb.append(0);
            }
            if (sum[i] != 0) {
                sb = sb.append(1);
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
