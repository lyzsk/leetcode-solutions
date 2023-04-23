import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/04/23
 **/
public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int maxHeight = 0;
            int curWidth = 0;
            for (int j = i; j >= 0; j--) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }
}
