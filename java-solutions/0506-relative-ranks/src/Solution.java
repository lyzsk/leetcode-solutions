import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/05/08
 **/
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] {i, score[i]};
        }
        Arrays.sort(sorted, (o1, o2) -> (o2[1] - o1[1]));
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[sorted[i][0]] = "Gold Medal";
            } else if (i == 1) {
                res[sorted[i][0]] = "Silver Medal";
            } else if (i == 2) {
                res[sorted[i][0]] = "Bronze Medal";
            } else {
                res[sorted[i][0]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
