import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/08/17
 **/
public class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        //记录上一行的值
        long[] pre = new long[n];
        //由于某行的dp值只与上一行的值有关，故只需要两个long[n]的数组作为dp数组做状态转移。
        for (int[] point : points) {
            //记录这一行的dp值
            long[] cur = new long[n];
            long best = Long.MIN_VALUE;
            //正序遍历
            //为何要正序，因为这时是在k在j左边的情况，那么max{dp[i-1][k] + k}中的k可取[0,j]
            for (int j = 0; j < n; j++) {
                best = Math.max(best, pre[j] + j);//相当于max{dp[i-1][k] + k}的操作
                cur[j] = Math.max(cur[j], point[j] - j + best);
            }
            best = Long.MIN_VALUE;
            //倒序遍历
            //为何要倒序，因为这时是k在j右边的情况，那么max{dp[i-1][k] - k}中的k可取[j,n-1]
            for (int j = n - 1; j >= 0; j--) {
                //再倒序遍历，找上一行最大的dp[i-1][k]-k
                best = Math.max(best, pre[j] - j);
                cur[j] = Math.max(cur[j], best + point[j] + j);
            }
            pre = cur;
        }
        //在最后一层找最大值
        return Arrays.stream(pre).max().getAsLong();
    }
}
